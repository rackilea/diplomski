@Override
public boolean getScrollableTracksViewportWidth() {
    //return this.getMinimumSize().width < this.getWidth();
    return this.getMinimumSize().width < getParent().getWidth();
}

@Override
public boolean getScrollableTracksViewportHeight() {
    //return this.getMinimumSize().height < this.getHeight();
    return this.getMinimumSize().height < getParent().getHeight();
}