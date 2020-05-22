@Override
public void paint(Graphics g) {
    BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = bi.createGraphics();

    super.paint(g2d);

    g2d.setColor(Color.LIGHT_GRAY);
    g2d.fillRoundRect(s.getx(), s.gety(), 10, 30, 10, 10);
    g2d.setColor(Color.GREEN);
    g2d.fillRoundRect(s.getx() - 5, s.gety() + 10, 5, 20, 10, 10);
    g2d.fillRoundRect(s.getx() + 10, s.gety() + 10, 5, 20, 10, 10);
    g2d.dispose();

    g.drawImage(bi, 0, 0, this);

}