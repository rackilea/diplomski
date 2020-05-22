deltaX = nextPointX - YourBirdX;
    deltaY = NextPointY - YourBirdY;
    degree = ((Math.atan2(deltaY, deltaX)));
    angle = degree * 180 / 3.14;

    if(angle<0)
    {
        angle = 360+angle;
    }