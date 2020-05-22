@Override
public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
{
    int increment = super.getScrollableUnitIncrement(visibleRect, orientation, direction);

    if (increment == 0)
        increment = 16;

    return increment;
}