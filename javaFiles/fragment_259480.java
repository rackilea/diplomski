@Override
public Dimension getPreferredSize()
{
    if (largeSize)
        return new Dimension(WIDTH, HEIGHT);
    else
        return new Dimension(WIDTH - 30, HEIGHT - 30);
}