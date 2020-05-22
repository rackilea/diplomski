@Override
public void paint(Graphics g) {
    super.paint(g);
    GraphicsUtilities.drawPictureTiled(background, g);
    paintComponents(g);
    g.dispose();
}