for (int i = 0; i < size; i++) {

    if(bullCount.get(i).getBounds().intersects(enemy.get(0).getBounds())) {
        enemy.remove(0);
        bullCount.remove(i);
    }