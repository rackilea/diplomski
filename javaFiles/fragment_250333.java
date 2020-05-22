public void changeCoord()
{
    int potentialX = pcX;
    int potentialY = pcY;

    if (movement.contains(Direction.LEFT)) potentialX--;
    if (movement.contains(Direction.RIGHT)) potentialX++;
    if (movement.contains(Direction.UP)) potentialY--;
    if (movement.contains(Direction.DOWN)) potentialY++;

    if (isValidMove(potentialX, potentially)
    {
        pcX = potentialX;
        pcY = potentialY;
    }

    repaint();
}


private boolean isValidMove(int potentialX, int potentialY)
{
    if (cords[potentialX][potentialY] == terrain[floor])
        return true;

    ...

    return false;
}