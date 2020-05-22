public void update(GameContainer game, int delta) {
    //...


    canGoLeft = true;
    canGoRight = true;
    canGoDown = true;
    canGoUp = true;
    for(Entity entity : Game.entities.entities) {
        checkCollisions(entity);
    }

public void checkCollisions(Entity entity) {

    // Collision Detection
    if(leftRect.intersects(entity.getRect())) {
        canGoLeft = false;
    }

    if(rightRect.intersects(entity.getRect())) {
        canGoRight = false;
    }

    if(topRect.intersects(entity.getRect())) {
        canGoUp = false;
    }

    if(bottomRect.intersects(entity.getRect())) {
        canGoDown = false;
    }
}