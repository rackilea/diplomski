Iterator<Sprite> enemyIterator = enemies.iterator();
while (enemyIterator.hasNext()){
    Sprite sprite = enemyIterator.next();
    if (sprite.getY() + sprite.getHeight() < screenBottom) //screenBottom is something you can calculate from your camera like camera.getPosition().y - camera.getHeight()/2
        removeEnemy(sprite);
}