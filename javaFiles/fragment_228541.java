xIndexEnemy = new Random().nextInt(3);
    if (delayTimer == 0) {
        while (xIndexEnemy == xIndexEnemyOld) {
            xIndexEnemy = new Random().nextInt(3);
        }
    }