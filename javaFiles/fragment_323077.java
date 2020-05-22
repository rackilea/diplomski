BufferedImage bi;
....
private void setImage(PanelOne panel) {
    Dimension d = panel.getPreferredSize();
    int w = (int)d.getWidth();
    int h =(int)d.getHeight();
    bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = bi.createGraphics();
    panel.paint(g);
    g.dispose();
}
....
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bi, 0, 0, 250, 250, 0, 0, 250, 250, this);
}