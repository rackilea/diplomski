public boolean keyDown(Event e, int key) {
    if(key==1004 && ballready) {
        ballready = false;
        ball.xchange = BallSpeedX;
        ball.ychange = BallSpeedY;
        showStatus(" ")
    }
    if(key==1006)
        leftArrow = true;
    if(key==1007)
        rightArrow = true;
    return true;
}