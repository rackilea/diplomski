@Override
public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    GeneralPath path = new GeneralPath();
    path.moveTo(10, 10);
    path.lineTo(10, 100);

    path.moveTo(100, 10);
    path.lineTo(100, 100);

    g2d.draw(path);
}