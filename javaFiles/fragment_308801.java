public class RightClickListener extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            tp.remove(tp.indexAtLocation(e.getX(), e.getY()));
        }
    }
}