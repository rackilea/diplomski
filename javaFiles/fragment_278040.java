public class Ball extends JComponent
{

    private double ballX;
    private double ballY;
    public static Ball[] balls = new Ball[20];

    public Ball()
    {
        ballX = rand.nextInt(500) + 40;
        ballY = rand.nextInt(300) + 10;
    }

    public void paintComponent(Graphics g2)
    {
        Color color = new Color(r, g, b);
        g2.setColor(color);
        g2.fillOval((int) ballX, (int) ballY, 30, 30);
    }
}