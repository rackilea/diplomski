public class ExampleAnimationOfMyStuff extends JPanel {

MovingRectangle[] rectangles = new MovingRectangle[20];

public ExampleAnimationOfMyStuff() {
    for (int i = 0; i < rectangles.length; i++) {
        rectangles[i] = new MovingRectangle();
    }
}

public static void main(String[] args) {
    JFrame frame = new JFrame("Animated rectangles");
    ExampleAnimationOfMyStuff anime = new ExampleAnimationOfMyStuff();
    frame.getContentPane().add(anime);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    anime.animate();
    frame.setVisible(true);
}

@Override
@Transient
public Dimension getPreferredSize() {
    return new Dimension(1000, 1000);
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (MovingRectangle rectangle : rectangles) {
        g.setColor(rectangle.color);
        g.fillRect(rectangle.x, rectangle.y, rectangle.width,
                rectangle.height);
    }
}

public void animate() {
    new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (MovingRectangle rectangle : rectangles) {
                rectangle.tick();
            }

            repaint();
            System.out.println("repainting");
        }
    }).start();
}



public static class MovingRectangle extends Rectangle {
    public static Random random = new Random();
    int speedX, speedY;
    Color color;

    public void tick() {
        if (getX() + speedX > 1000 || getX() + speedX < 0) {
            speedX *= -1;
        }

        if (getY() + speedY > 1000 || getY() + speedY < 0) {
            speedY *= -1;
        }

        setRect(getX() + speedX, getY() + speedY, getWidth(), getHeight());
    }

    public MovingRectangle() {
        super(random.nextInt(1000), random.nextInt(1000), random
                .nextInt(40), random.nextInt(40));

        this.speedX = (random.nextDouble() > 0.5) ? 4 : -4;
        this.speedY = (random.nextDouble() > 0.5) ? 4 : -4;
        this.color = new Color(random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
    }
}

}