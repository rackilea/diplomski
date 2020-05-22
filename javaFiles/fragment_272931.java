public void restart() {
    stage = new Stage();
    player = new Player(this, 200, 500);
    manager = new EnemyManager(this, 10);
    isGameOver = false;
}
...

@Override
public void keyPressed(KeyEvent e) {
...
    if (code == KeyEvent.VK_R){
        restart();
    }
  }