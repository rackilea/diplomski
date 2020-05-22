// Reference to the last known position of the mouse...
private Point mousePoint;
//....
addMouseMotionListener(new MouseAdapter() {
    @Override
    public void mouseMoved(MouseEvent e) {
        mousePoint = e.getPoint();                    
        repaint();                    
    }                
});