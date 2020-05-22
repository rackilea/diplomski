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