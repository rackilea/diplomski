public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    g2d.setColor(Color.WHITE);
    Rectangle rect2 = new Rectangle(100, 100, 20, 20);

    g2d.rotate(Math.toRadians(45));
    g2d.draw(rect2);
    g2d.fill(rect2);
}