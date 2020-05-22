while(blastIter.hasNext()) {
    Rectangle blast = blastIter.next();
    blast.x += 200 * Gdx.graphics.getDeltaTime();
    boolean removed = false;
    if(blast.x + 16 > window.length) {
        blastIter.remove();
        removed = true;
    }
    zombieIter = zombies.iterator();
    while(zombieIter.hasNext() && !removed) {
        Zombie zombie = zombieIter.next();
        if(zombie.overlaps(blast)) {
            removed = true;
            zombie.removeHealth(5);
            blastIter.remove();
            if (zombie.isDead()) {
                zombiesSlain++;
                zombieIter.remove();
            }
        }
    }
}