if (xIndexEnemy != xIndexMoney && xIndexEnemy != xIndexFriend) {
        Enemy enemy = new Enemy(xCoordinates[xIndexEnemy]);
        enemies.add((Enemy) enemy);
    } else {
        generateNewEnemy();
    }
}