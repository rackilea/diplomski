class MultiKeyPressListener implements KeyListener {

  // Set of currently pressed keys
  private final Set<Integer> pressed = new HashSet<Integer>();

  @Override
  public synchronized void keyPressed(KeyEvent e) {
    pressed.add(e.getKeyCode());

    if (pressed.contains(KeyEvent.VK_UP)) {
      if (pressed.contains(KeyEvent.VK_LEFT)) {
        starfighter.moveUpLeft();
      }
      if (pressed.contains(KeyEvent.VK_RIGHT)) {
        starfighter.moveUpRight();
      }
    }
  }

  @Override
  public synchronized void keyReleased(KeyEvent e) {
    pressed.remove(e.getKeyCode());
  }

  @Override
    public void keyTyped(KeyEvent e) {/* Not used */ }
  }
}