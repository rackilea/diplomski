@Override
public void actionPerformed(ActionEvent e) {
    final int MOVE = 50;
    if (e.getSource() == moveLeft) {
        horizontal -= MOVE;
    } else {
        horizontal += MOVE;

    }
    repaint();
}