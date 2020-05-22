@Override
public Dimension getPreferredScrollableViewportSize() 
{
    int headerHeight = table.getTableHeader().getPreferredSize().height;
    int height = headerHeight + (10 * getRowHeight());
    int width = getPreferredSize().width;
    return new Dimension(width, height);
}