private long lastTimeHit= 0;

if(collision && System.currentTimeMillis() > lastTimeHit+3000){
    lastTimeHit= System.currentTimeMillis();
    player.health--;
}