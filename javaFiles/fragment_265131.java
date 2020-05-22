g2.fillRect(0, 0, width, height);

if (topLinePainted)
{
    g2.setStroke (new BasicStroke (10));
    g2.setColor(Color.RED);
    g2.drawLine(0, 0, width, 0);
}