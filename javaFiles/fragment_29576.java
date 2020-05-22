@Override
public void mouseMoved(MouseEvent e) {
    for (DrawnRectangle r : rectangles) {
       if (r.contains(e.getX(), e.getY())){
           r.setHoverBackground();
       }
    }
}