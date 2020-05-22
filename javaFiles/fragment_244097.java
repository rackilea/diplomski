public class CustomLayout implements LayoutManager {
    private final JTextPane txt1;
    private final JTextPane txt2;
    private final JTextPane txt3;

public CustomLayout(JTextPane aTxt1, JTextPane aTxt2, JTextPane aTxt3) {
    txt1 = aTxt1;
    txt2 = aTxt2;
    txt3 = aTxt3;
}

@Override
public void addLayoutComponent(String name, Component comp) {
}

@Override
public void removeLayoutComponent(Component comp) {
}

@Override
public Dimension preferredLayoutSize(Container parent) {
    int width = parent.getParent().getWidth();

    int height = 0;

    height += calculateComponentPreferredHeightForWidth(txt1, width);
    height += calculateComponentPreferredHeightForWidth(txt2, width);
    height += calculateComponentPreferredHeightForWidth(txt3, width);

    return new Dimension(width, height);
}

private static int calculateComponentPreferredHeightForWidth(JComponent component, int width) {
    component.setSize(width, 0);
    return component.getPreferredSize().height;
}

@Override
public Dimension minimumLayoutSize(Container parent) {
    return preferredLayoutSize(parent);
}

@Override
public void layoutContainer(Container parent) {
    int width = parent.getWidth();

    int layoutX = 0;
    int layoutY = 0;

    txt1.setBounds(layoutX, layoutY, width, calculateComponentPreferredHeightForWidth(txt1, width));
    layoutY = txt1.getY() + txt1.getHeight();

    txt2.setBounds(layoutX, layoutY, width, calculateComponentPreferredHeightForWidth(txt2, width));
    layoutY = txt2.getY() + txt2.getHeight();

    txt3.setBounds(layoutX, layoutY, width, calculateComponentPreferredHeightForWidth(txt3, width));
}