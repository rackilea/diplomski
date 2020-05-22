public int compareTo(Downtown p2)//Actual comparison
{
    // This is so that the sort goes x first, y second and rank last

    // First by x- stop if this gives a result.
    int xResult = Integer.compare(getX(),p2.getX());
    if (xResult != 0)
    {
        return xResult;
    }

    // Next by y
    int yResult = Integer.compare(getY(),p2.getY());
    if (yResult != 0)
    {
        return yResult;
    }

    // Finally by rank
    return Integer.compare(getRank(),p2.getRank());
}