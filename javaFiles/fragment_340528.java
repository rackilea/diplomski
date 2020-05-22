private void shareTouch(float x) 
{
    if (x < gameViewWidth/2) {
        fingersLeft++;
    } else {
        fingersRight++;
    }
}

private void clearTouches() 
{
    fingersLeft = 0;
    fingersRight = 0;
}