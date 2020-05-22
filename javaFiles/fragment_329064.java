private void doMovement(int movementX, int movementY)
{
    int oldX = theFrame.getX();
    int oldY = theFrame.getY();
    int newX = oldX + movementX;
    int newY = oldY + movementY;
    theFrame.setLocation(newX, newY);
}