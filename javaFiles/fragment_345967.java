import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBalls{

    BouncingBalls(int numOfBalls) {

        Model model = new Model();
        View view = new View(model);;

        for (int i = 0; i < numOfBalls; i++) {
            Ball b = new Ball(); //construct  a ball
            model.addBall(b);    //add it to the model 
            b.registerObserver(view.getObserver());  //register view as an observer to it 
            new BallAnimator(b, model.getWidth(), model.getHeight()); //start a thread to update it 
        }

        view.createAndShowGui();
    }

    public static void main(String[] args) {
        new BouncingBalls(5);
    }
}

//listening interface. Implemented by View and used by Ball to notify changes
interface Observer {
    void onObservableChanged();
}

class View {

    private final BallsPane ballsPane;

    View(Model model){
        ballsPane = new BallsPane(model);
    }

    void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(ballsPane);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    Observer getObserver(){
        return ballsPane;
    }
}

class BallsPane extends JPanel implements Observer {

    private final Model model;

    BallsPane(Model model){
        this.model = model;
        setPreferredSize(new Dimension(model.getWidth(), model.getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Ball b : model.getBalls()){
            g.setColor(b.getColor());
            g.fillOval(b.getX(), b.getY(), b.getSize(), b.getSize());
        }
    }

    @Override
    public void onObservableChanged() {
        repaint(); //when a change was notified
    }
}

//view model: hold info that view needs
class Model {

    private final ArrayList<Ball> balls;
    private final int width, height;

    Model(){
        balls = new ArrayList<>();
        width = 300; height = 200;
    }

    boolean addBall(Ball ball){
        return balls.add(ball);
    }

    List<Ball> getBalls() {
        return new ArrayList<>(balls); //return a copy of balls
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}

//a model representing ball
class Ball  {

    //Ball attributes
    private static final int SIZE = 10;  //diameter
    private int x, y;  // Position
    private final Color color;
    private Observer observer;  //to be notified on changes

    Ball() {

        Random rnd = new Random();
        color = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    Color getColor() {
        return color;
    }

    int getSize(){
        return SIZE;
    }

    synchronized int getX() {
        return x;
    }

    synchronized void setX(int x) {
        this.x = x;
        notifyObserver();
    }

    synchronized int getY() {
        return y;
    }

    synchronized void setY(int y) {
        this.y = y;
        notifyObserver();
    }

    void registerObserver(Observer observer){
        this.observer = observer;
    }

    void notifyObserver(){
        if(observer == null) return;
        observer.onObservableChanged();
    }
}

class BallAnimator implements Runnable{

    private final Ball ball;
    private final int maxX, maxY;
    private final Random rnd;
    private boolean moveRight = true,  moveDown = true;
    private static final int STEP =1, WAIT = 40;

    BallAnimator(Ball ball, int maxX, int maxY) {
        this.ball = ball;
        this.maxX = maxX;
        this.maxY = maxY;
        rnd = new Random();
        ball.setX(rnd.nextInt(maxX - ball.getSize()));
        ball.setY(rnd.nextInt(maxY - ball.getSize()));
        new Thread(this).start();
    }

    @Override
    public void run() {

        while(true){

            int dx = moveRight ? STEP : -STEP ;
            int dy = moveDown  ? STEP : -STEP ;

            int newX = ball.getX() + dx;
            int newY = ball.getY() + dy;

            if(newX + ball.getSize()>= maxX || newX <= 0){
                newX = ball.getX() - dx;
                moveRight = ! moveRight;
            }

            if(newY +ball.getSize()>= maxY || newY <= 0){
                newY = ball.getY() - dy;
                moveDown = ! moveDown;
            }

            ball.setX(newX);
            ball.setY(newY);

            try {
                Thread.sleep(WAIT);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}