@Override
public void mouseMoved(MouseEvent e) {
    int x = e.getX(), y = e.getY();
    if (shape.contains(x, y)) {
        mouseMoveX = e.getX();
        mouseMoveY = e.getY();
    }
    else {
        // get angle of rotation
        double r = Math.atan2(y-shape.getCenterY(),x-shape.getCenterX());
        mouseMoveX = (int) (shape.getWidth()/2 * Math.cos(r) + shape.getCenterX());
        mouseMoveY = (int) (shape.getHeight()/2 * Math.sin(r) + shape.getCenterY());
    }
}