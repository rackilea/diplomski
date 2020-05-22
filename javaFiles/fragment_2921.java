/**
     * {@inheritDoc} <p>
     * 
     * Overridden to hack around #766-swingx: cursor flickering in DnD
     * when dragging over tree column. This is a core bug (#6700748) related
     * to painting the rendering component on a CellRendererPane. A trick
     * around is to let this return false. <p>
     * 
     * This implementation applies the trick, that is returns false always. 
     * The hack can be disabled by setting the treeTable's client property
     * DROP_HACK_FLAG_KEY to Boolean.FALSE. 
     * 
     */
    @Override
    public boolean isVisible() {
        return shouldApplyDropHack() ? false : super.isVisible();
    }


    /**
     * Returns a boolean indicating whether the drop hack should be applied.
     * 
     * @return a boolean indicating whether the drop hack should be applied.
     */
    protected boolean shouldApplyDropHack() {
        return !Boolean.FALSE.equals(treeTable.getClientProperty(DROP_HACK_FLAG_KEY));
    }