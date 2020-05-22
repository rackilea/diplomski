@Override
public Dimension getPreferredSize()
{
    Dimension preferredSize = super.getPreferredSize();
    Component parent = getParent();

    if (parent == null)
        return preferredSize;

    Dimension parentSize = parent.getSize();
    Dimension minimumSize = getMinimumSize();

    int width = Math.min(preferredSize.width, parentSize.width);
    width = Math.max(width, minimumSize.width);

    int height = Math.min(preferredSize.height, parentSize.height);
    height = Math.max(height, minimumSize.height);

    return new Dimension(width, height);
}