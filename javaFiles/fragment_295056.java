@Override
public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
    case KeyEvent.VK_UP:
        view.translatePiece(0, -100);
        break;
    case KeyEvent.VK_DOWN:
        view.translatePiece(0, +100);
        break;
    case KeyEvent.VK_LEFT:
        view.translatePiece(-100, 0);
        break;
    case KeyEvent.VK_RIGHT:
        view.translatePiece(+100, 0);
        break;
    }
}