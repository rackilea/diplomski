@Override
public void keyPressed(KeyEvent arg0) {
    if (arg0.getKeyCode() == 27) { // 27 is ascii code for esc button
        JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(this);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}