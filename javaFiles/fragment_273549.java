public void keyPressed(KeyEvent e) {
    // TODO: your are actually moving the circle down, so it should be VK_DOWN
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        CircleFrame.y += 1;
        repaint();
    }
}