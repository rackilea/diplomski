void translatePiece(int dx, int dy) {
    if (current != null) {
        current.x += dx;
        current.y += dy;
        repaint();
    }
}