private void newEnemy(){
    Sprite newEnemy = Pools.obtain(Sprite.class);
    newEnemy.set(enemy); //I recommend renaming your `enemy` variable to something like `prototypeEnemy` for clarity
    newEnemy.setPosition(200, 700); //need to start it at correct location.
    enemies.add(newEnemy);
}