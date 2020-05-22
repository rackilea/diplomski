class Point
{
    final int x;
    final int y;

    Point(final double x, final double y)
    {
        this.x = (int) x; // we're dealing with pixels, so just truncate it
        this.y = (int) y;
    }

    @Override
    public String toString()
    {
        return "{" + x + ", " + y + "}";
    }
}