public void checkTouch()
{
    if (fingersLeft > fingersRight) {
        moveLeft();
    } else if (fingersRight > fingersLeft) {
        moveRight();
    }
}