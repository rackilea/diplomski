public boolean collidesWith(Rectangle object){
    if (isDestroyed) {
        return false;
    } else {
        return hitbox.intersects(object);
    }
}