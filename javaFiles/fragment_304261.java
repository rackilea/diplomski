private void startUpdateTicker() {
    final AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
                updateEnemies();
        }
    };
    timer.start();
}

public synchronized void updateEnemies() {
        for (EnemieGUI enemy : enemyList) {
            enemy.relocate(enemy.getEnemie().getxCoordinate(), enemy.getEnemie().getyCoordinate());
        }
}