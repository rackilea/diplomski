public class BunchOfListeners implements MouseListener, KeyListener, FocusListener {

    @Override
    public void focusGained(FocusEvent e) {
        doSomething(e);
    }

    @Override
    public void focusLost(FocusEvent e) {
        doSomething(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        doSomething(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        doSomething(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        doSomething(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        doSomething(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        doSomething(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        doSomething(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        doSomething(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        doSomething(e);
    }

    public void doSomething(EventObject e) {
        ((Component) e.getSource()).repaint();
    }
}