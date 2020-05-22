// Override getScrollableTracksViewportWidth
// to preserve the full width of the text
public boolean getScrollableTracksViewportWidth() {
    Component parent = getParent();
    ComponentUI ui = getUI();

    return parent != null ? (ui.getPreferredSize(this).width <= parent
        .getSize().width) : true;
}