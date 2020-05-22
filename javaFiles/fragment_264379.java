class Mover implements MouseListener, MouseMotionListener {
    private boolean moving;
    private Point movementOrigin;
    public void mouseClicked(MouseEvent e) {
        if (moving = !moving)
            movementOrigin = e.getPoint();
    }
    public void mouseMoved(MouseEvent e) {
        if (!moving) return;
        Point pos = e.getPoint();
        Point delta = new Point(pos.getX() - movementOrigin.getX(), pos.getY() - movementOrigin.getY());
        // TODO Relocate the circle with that delta
        repaint();
    }
}