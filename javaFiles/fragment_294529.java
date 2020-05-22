public void tick() {

    if (up) {
        y -= SPEED;
    } else if (dn) {
        y += SPEED;
    } else if (lt) {
        x -= SPEED;
    } else if (rt) {
        x += SPEED;
    }

    playerR.setLocation(x, y);

    for (Rectangle collideable : Level.collisions) {
        if (intersects(playerR, collideable)) {
            x = locx;
            y = locy;
            playerR.setLocation(x, y);
            break;
        }
    }

    locx = x;
    locy = y;

}