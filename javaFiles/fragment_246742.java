@Override
public Dimension getPreferredSize()
{
    Dimension d = super.getPreferredSize();

    BorderLayout layout = (BorderLayout)getLayout();
    Component center = layout.getLayoutComponent(BorderLayout.CENTER);

    int centerHeight = center.getPreferreidSize().height;

    if (d.height > centerHeight)
        d.height = centerHeight;

    return d;
}