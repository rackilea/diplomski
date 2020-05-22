@Override
public Component getComponentAt(int x, int y)
{
    Point translated = getTranslatedPoint(x, y);

    for (Component c: getComponents())
    {
        if (c.getBounds().contains(translated))
            return c;
    }

    return null;
}

public Point getTranslatedPoint(int x, int y)
{
    int translatedX = x + scrollOffset;

    if (isWrap())
    {
        int preferredWidth = super.getPreferredSize().width;
        preferredWidth += getWrapAmount();
        translatedX = translatedX % preferredWidth;
    }

    return new Point(translatedX, y);
}