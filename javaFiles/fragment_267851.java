private boolean displayGrid = true;

public boolean isDisplayGrid() {
    return displayGrid;
}
public void setDisplayGrid(boolean displayGrid) {
    this.displayGrid = displayGrid;
    repaint();
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    ...
    if (displayGrid)
        drawGrid(g2);
}