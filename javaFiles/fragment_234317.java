@Override
public Dimension getPreferredSize()
{
    // If the preferred size was set manually, return this
    // size in order to be in line with the specification
    // that is described in the JavaDoc
    if (super.isPreferredSizeSet())
    {
        return super.getPreferredSize();
    }

    // Otherwise, return "your" preferred size. The
    // DEFAULT_WIDTH and DEFAULT_HEIGHT would be 20,20
    // in your case
    return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
}