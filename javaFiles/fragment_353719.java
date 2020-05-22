private static final long TOTAL_DEATH_TIME = 1000L; // total time of your delay

private long deathInitTime = -1L;  // start time of death throes

public void actionPerformed(ActionEvent e) {
    if (!louis.isDead) {

        // .... etc... unchanged from your code

    } else {
        // he's dead
        if (deathInitTime < 0) {
            // if dead but just now dead, initialize deathInitTime
            deathInitTime = System.currentTimeMillis();
        } else {
            // he's been dead
            // check how long he's been dead
            long deathTime = System.currentTimeMillis() - deathInitTime;
            if (deathTime > TOTAL_DEATH_TIME) {
                // if he's been dead long enough, call this code
                mapX = initMapX;
                mapY = initMapY;
                louis = new Player(spawnX, spawnY);
                deathInitTime = -1L;  // and re-initialize deathInitTime
            }
        }
    }
    repaint();
}