private int bulletStartingXPosition = 405;
private int bulletYPosition;    //depends on player position
private final int BULLET_DX = 5;    //not final

// NEW STUFF
private int bulletXPosition;
private boolean showingBullet = false;

public void paint(Graphics g){
    g.drawImage(background,0,0,null);
    g.drawImage(cow,-15,115,null);
    g.drawImage(cow,-15,255,null);
    g.drawImage(cow,-15,400,null);
    g.drawImage(cow,-15,550,null);
    g.drawImage(normalZombie,zombieStartingXPosition,100,null);
    g.drawImage(tankyZombie,zombieStartingXPosition,400,null);
    g.drawImage(fastZombie,zombieStartingXPosition,255,null);
    g.drawImage(player,PLAYER_X_POSITION,playerYPosition, null);
    //g.drawImage(bullet,bulletStartingXPosition,336,this);
    g.drawImage(bloodSplat,bloodSplatX,bloodSplatY,null);

    // NEW STUFF
    if (showingBullet) {
       g.drawImage(bullet,bulletXPosition, playerYPosition, null);
       bulletXPosition += BULLET_DX;
       if (bulletXPosition > 1100) { // if it went off the screen
           showingBullet = false;
       }
    }
}

public void spawnBullet() {

    // NEW STUFF
    if (showingBullet) {
        return; // don't want to reset the bullet if it's already on the screen
    }
    showingBullet = true;
    bulletXPosition = bulletStartingXPosition;
}