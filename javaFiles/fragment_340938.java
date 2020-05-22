public void paintComponent(Graphics g)
{
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(5));
    g2.drawLine(4,4,95,95);
    g2.drawLine(4,95,95,4);
    g2.setStroke(new BasicStroke(1));
}