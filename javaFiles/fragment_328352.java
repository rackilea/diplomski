public void reset() {
        x = random.nextInt(GamePanel.WIDTH);
        y = random.nextInt(GamePanel.HEIGHT);
        dy = (random.nextInt()*(GamePanel.HEIGHT - (maxBorderHeight* 2)+maxBorderHeight));
        dx = +GamePanel.MOVESPEED;
    }