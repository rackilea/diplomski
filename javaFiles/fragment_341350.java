//for example, Bob colliding with squirrels
private void checkSquirrelCollisions(){
    int len = squirrels.size();
    for (int i = 0; i < len; i++){
        Squirrel squirrel = squirrels.get(i);
        if (squirrel.bounds.overlaps(bob.bounds)){
            bob.hitSquirrel();
            listener.hit();
        }
    }
}