@Override
public void keyTyped(KeyEvent e) {
    for (Tile t : model.getTiles()) {
        if (t.getChar() == e.getKeyChar()) {
            System.out.println("YOU REMOVED A TILE!!!");
            frame.remove(t);
            frame.repaint();
        }
    }
    // model.removeByChar(e.getKeyChar());
}