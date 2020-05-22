@Override
public void mouseClicked(MouseEvent e) {
    int squareX = (int)e.getX() / SIZE;
    int squareY = (int)e.getY() / SIZE;
    grid[squareY][squareX] = !grid[squareY][squareX];
    repaint();
}