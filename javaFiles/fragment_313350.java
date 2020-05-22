import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Main extends JPanel implements KeyListener, ActionListener{
    public static class FPSCounter implements ActionListener {
        private final Timer resetTimer;
        private int current, last;

        public FPSCounter() {
            resetTimer = new Timer(1000, this);
        }

        public synchronized void start() {
            resetTimer.start();
            current = 0;
            last = -1;
        }

        public synchronized void stop() {
            resetTimer.stop();
            current = -1;
        }

        public synchronized void frame() {
            ++current;
        }

        @Override
        public synchronized void actionPerformed(final ActionEvent e) {
            last = current;
            current = 0;
        }

        public synchronized int get() {
            return last;
        }
    }


// Variabler
JFrame frame;
int windowWidth, windowHeight;
Point ballXY;
int screenWidth, screenHeight;
Timer timer;
Image imagePaddle;
Image imageBall;
int paddleY;
int paddle2Y;
boolean paddelUp, paddelDown;
Random rand;
int score, score2;
boolean ballUp, ballRight, changeDirection;
boolean paused;
int DistanceRand;
long time;
int fps, newfps;

private final FPSCounter fpscnt; //added line (step 1).

// Konstruktor
public Main(){
    // Definera variabler
    frame = new JFrame();
    imagePaddle = new ImageIcon("src/images/Player.png").getImage();
    imageBall = new ImageIcon("src/images/Pong.png").getImage();
    ballXY = new Point(673, 352);
    paddleY = 312;
    paddle2Y = 312;
    paddelUp = false;
    rand = new Random();
    score = 0;
    score2 = 0;
    ballUp = false;
    ballRight = false;
    changeDirection = false;
    paused = false;
    DistanceRand = 0;
    time = System.currentTimeMillis();
    fps = 0;
    newfps = 0;

    // Lyssnare
    frame.addKeyListener(this);

    // Bygga fönstret

    frame.add(this);

    // Obligatoriska egenskaper
    frame.setTitle("Pong");
    frame.setSize(1366, 724);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    this.setBackground(Color.BLACK);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    ballUp = true;
    ballRight = true;
    changeDirection = false;
    ballXY = new Point();

    frame.add(this);

    timer = new Timer(5, this);
    timer.start();

    fpscnt = new FPSCounter(); //added line (step 2).
    fpscnt.start(); //added line (step 3).
}
// Metoder
public static void main(String[] args) {
    new Main();
}

@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);

    g.drawImage(imageBall, ballXY.x, ballXY.y, null);
    g.drawImage(imagePaddle, 50, paddleY, null);
    g.drawImage(imagePaddle, 1300, paddle2Y, null);
    g.setFont(new Font("Arial", Font.BOLD, 100));
    g.setColor(Color.WHITE);
    g.drawString(score2 + "", 1002, 100);
    g.drawString(score + "", 314, 100);

    if(paused){ 
        g.setFont(new Font("Arial", Font.BOLD, 80));
        g.drawString("PAUSED", 510, 370);
        timer.stop();
    }
    if(System.currentTimeMillis() - time >= 1000){
        time = System.currentTimeMillis();
        fps = newfps;
        newfps = 0;
    }
    else{
        newfps++;
    }
    fpscnt.frame(); //added line (step 4).
    g.setFont(new Font("Arial", Font.BOLD, 25));
    g.drawString("" + fpscnt.get(), 5, 22); //added line (step 5).
}

public void AI(){
    DistanceRand = rand.nextInt(200) + 960;
    if(ballXY.x > DistanceRand && ballXY.x < 1380 && ballRight && paddle2Y > 0 && paddle2Y < 596){
        if(paddle2Y + 50 < ballXY.y){
            paddle2Y = paddle2Y + 3;
        }
        else{
            paddle2Y = paddle2Y - 3;
        }
        if(paddle2Y <= 0){
            paddle2Y = paddle2Y + 3;
        }
        if(paddle2Y >= 596){
            paddle2Y = paddle2Y - 3;
        }
    }
}

public void ifUp(){
    if(ballUp){
        if(changeDirection){
            if(ballXY.y < 0){
                ballUp = false;
            }
            else{
                ballXY.y = ballXY.y - 3;
            }
        }
        else{
            if(ballXY.y < 0){
                ballUp = false;
            }
            else{
                ballXY.y = ballXY.y - 3;
            }
        }
    }

    else{
        if(changeDirection){
            if(ballXY.y > 675){
                ballUp = true;
            }
            else{
                ballXY.y = ballXY.y + 3;
            }
        }
        else{
            if(ballXY.y > 675){
                ballUp = true;
            }
            else{
                ballXY.y = ballXY.y + 3;
            }
        }
    }
}

public void update(){
    if(paddelUp){
        if(paddleY > 0){
            paddleY = paddleY - 3;
        }
    }
    if(paddelDown){
        if(paddleY < 596){
            paddleY = paddleY + 3;
        }
    }

    if(ballRight){

        if(ballXY.x > 1290 && ballXY.x < 1300 && ballXY.y < paddle2Y + 100 && ballXY.y > paddle2Y-20){

            if(!ballUp && ballXY.y < paddle2Y){
                changeDirection = true;
                ballUp = true;
            }
            else if(ballUp && ballXY.y > paddle2Y + 80){
                changeDirection = true;
                ballUp = false;
            }

            ballRight = false;

        }
        else if(ballXY.x > 1600){
            score++;
            ballXY.y = rand.nextInt(690);
            ballXY.x = 678;
        }
        else
            ballXY.x = ballXY.x + 3;


        ifUp();
    }
    else{
        if(ballXY.x > 50 && ballXY.x < 60 &&ballXY.y < paddleY + 100 && ballXY.y > paddleY-20){
            if(!ballUp && ballXY.y < paddleY){
                changeDirection = true;
                ballUp = true;
            }
            else if(ballUp && ballXY.y > paddleY + 80){
                changeDirection = true;
                ballUp = false;
            }
            ballRight = true;
        }
        else if(ballXY.x < -244){
            score2++;
            ballXY.x = 678;
            ballXY.y = rand.nextInt(596);
        }
        else
            ballXY.x = ballXY.x - 3;

        ifUp();
    }
    AI();
    repaint();
}

@Override
public void actionPerformed(ActionEvent e) {
    update();
}

@Override
public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
        paddelUp = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
        paddelDown = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_SPACE){
        if(paused){
            paused = false;
            timer.start();
        }
        else{
            paused = true;
        }
    }
}

@Override
public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
        paddelUp = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
        paddelDown = false;
    }
}

@Override
public void keyTyped(KeyEvent e) {

}
}