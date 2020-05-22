public boolean collidesWith(GameObject caller, Class<? extends GameObject> collideType) {
    for ( /* the array of all GameObjects */ ) {
        if(collideType.isInstance(gameObjects[i])) {
            // continue doing collision checks
            // return true in here somewhere
        }
        else continue;
    }
    return false;
}