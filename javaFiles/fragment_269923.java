private void move(){
    if(!instance.getStage().isCollided(hitbox)){
        directionY = 1;
    } else { directionY = 0;
    hitbox.x += directionX;
    hitbox.y += directionY;
    }
}

if(instance.getEnemyManager().isCollided(hitbox)){