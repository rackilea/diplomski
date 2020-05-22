public void swapColors(Block g1, Block g2) {
    Color c = g1.getColor();
    g1.setColor(g2.getColor());
    g2.setColor(c);
    repaint();
}