public class MyMouseMotionListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {
        // consume the event so the globe position does not change
        e.consume();
        if (e.getSource() instanceof WorldWindowGLCanvas) {
            // get the position of the mouse
            final WorldWindowGLCanvas canvas = ((WorldWindowGLCanvas) e.getSource());
            final Position p = canvas.getCurrentPosition();
            // do something with the position here
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        e.consume();
    }
}