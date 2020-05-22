class CheckboxPanel
extends JPanel
implements Scrollable {
    private final int checkBoxHeight;

    public CheckboxPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        checkBoxHeight = new JCheckBox("Example").getPreferredSize().height;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        // This prevents a horizontal scrollbar from appearing.
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect,
                                          int orientation,
                                          int direction) {
        if (orientation == SwingConstants.HORIZONTAL) {
            return 1;
        }

        return Math.min(checkBoxHeight, direction < 0 ?
            visibleRect.y : getHeight() - (visibleRect.y + visibleRect.height));
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect,
                                           int orientation,
                                           int direction) {
        if (orientation == SwingConstants.HORIZONTAL) {
            return 10;
        }

        return Math.min(visibleRect.height, direction < 0 ?
            visibleRect.y : getHeight() - (visibleRect.y + visibleRect.height));
    }
}