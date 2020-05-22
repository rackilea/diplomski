public void drawFlake(int level, float angleDegrees, Graphics g) {
    /* 
     * Exit condition
     * If the max number of levels has been reached, 
     * or the maxLength is no longer visible when drawn
     */
    if (level >= MAX_LEVEL || maxLength == 0) {
        return;
    }

    /*
     * Secondary condition, increment the level if we've gone around the 
     * circle once
     */
    if (angleDegrees >= 360) {
        maxLength *= .9;
        drawFlake(level + 1, 0, g);
        return;
    }

    g.drawLine(
        centerX,
        centerY,
        centerX + (int) (maxLength * Math.sin(Math.toRadians(angleDegrees))),
        centerY + (int) (maxLength * Math.cos(Math.toRadians(angleDegrees))));

    int currentLevelAngleIncrement = 60 / (level + 1);
    drawFlake(level, angleDegrees + currentLevelAngleIncrement, g);
}