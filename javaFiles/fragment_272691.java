@Override
public void paintComponent(Graphics g) {
    double proportion = (expected == 0) ? 0 : ((double) actual) / expected;
    Rectangle bounds = super.getBounds();
    g.setColor(BACKGROUND);
    g.fillRect(0, 0, bounds.width, bounds.height);
    g.setColor(BAR_GRAPH_COLOR);
    g.fillRect(0, 0, (int) (bounds.width * proportion), bounds.height);
    g.setColor(BORDER_COLOR);
    g.drawRect(0, 0, bounds.width-1, bounds.height-1);
    label.setText(String.format("%s of %s (%.1f%%)", actual, expected, proportion * 100));
}