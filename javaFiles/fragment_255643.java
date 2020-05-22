public void repaint() {
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
    g.fillRect(0,0, getWidth(), getHeight());
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    paint(g);
}