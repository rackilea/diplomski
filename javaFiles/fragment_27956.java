private void gameUpdate() {
    if (!paused && !gameOver) {
        movePlayer();
        foreach(Bullet bullet : player.getFiredBullets(){
             bullet.moveInDirection();
        }
    }
}