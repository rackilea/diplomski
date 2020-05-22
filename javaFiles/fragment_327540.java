@Override
public Dimension getPreferredSize()
{
    Dimension parentSize = getParent().getSize();
    int width = (parentSize.width / 50) * 50;
    int height = (parentSize.height / 50) * 50;
    return new Dimension(width, height);
}