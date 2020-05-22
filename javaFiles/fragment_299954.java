public class BigPane extends JPanel implements Scrollable {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(200, 200);
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 128;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 128;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        boolean track = true;
        Container parent = getParent();
        if (parent instanceof JViewport) {

            JViewport viewport = (JViewport) parent;
            if (viewport.getHeight() < getPreferredSize().height) {
                track = false;
            }

        }

        return track;
    }

}