for(Enemy enemy : arrayEnemy) {
    //Set the animation texture for the enemy object
    switch (enemy.getStateEnemy()) {
        case Walking:
            frameEnemy = animWalkEnemy.getKeyFrame(stateTime);
            break;  
        case Deadening:
            frameEnemy = animDeadEnemy.getKeyFrame(stateTime);
            break;  
    }

    //Render the enemy object
    batch.draw(frameEnemy, enemy.getRect().x, enemy.getRect().y, Enemy.WIDTH, Enemy.HEIGHT);
}