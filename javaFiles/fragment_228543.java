public static void generateNewEnemy() {
    xIndexEnemy = new Random().nextInt(3);
    if (delayTimer == 0) {
        while (xIndexEnemy == xIndexEnemyOld) {
            xIndexEnemy = new Random().nextInt(3);
        }
    }

    Enemy enemy = new Enemy(xCoordinates[xIndexEnemy]);
    enemies.add((Enemy) enemy);
    xIndexEnemyOld = xIndexEnemy;
    // Now that you used the new index you can store it as the Old one
}