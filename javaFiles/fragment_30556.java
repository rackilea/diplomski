class Arena extends JPanel {
  Player pl;

  Arena() {
    pl = new Player();
  }

  class Kadapter extends KeyAdapter {
    @Override
    public void KeyPressed(KeyEvent e) {
    }
  }
}