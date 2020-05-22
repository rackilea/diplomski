public class Mouse implements MouseMotionListener {

    private static final long serialVersionUID = 7986961236445581989L;

    int mx, my;
    boolean mouseDragged;

    @Override
    public void mouseDragged(MouseEvent e) {
        mx = e.getX() - 10;
        my = e.getY() - 10;

        mouseDragged = true;

        e.consume();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mx = e.getX() - 10;
        my = e.getY() - 10;

        mouseDragged = false;
        e.consume();
    }

}