//A helper method to determine if a coordinate is within a rectangle
private boolean isXYInRect(float x, float y, Rect rect)
{
    //If it is within the bounds...
    if (x > rect.left &&
        x < rect.right &&
        y > rect.top &&
        y < rect.bottom)
    {
        //Then it's a hit
        return true;
    }

    //Otherwise, it's a miss
    return false;
}