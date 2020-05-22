@Override
protected void paintHorizontalPartOfLeg(Graphics g, Rectangle clipBounds,
        Insets insets, Rectangle bounds, TreePath path, int row,
        boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf) {
    boolean toPaint = (!this.tree.isEnabled())
            || this.isInside
            || !FadeConfigurationManager.getInstance().fadeAllowed(
                    SubstanceLookAndFeel.TREE_DECORATIONS_ANIMATION_KIND,
                    tree);
    if (FadeTracker.getInstance().isTracked(this.tree, SubstanceLookAndFeel.TREE_DECORATIONS_ANIMATION_KIND)) {
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setComposite(TransitionLayout
                .getAlphaComposite(this.tree,
                        FadeTracker.getInstance()
                            .getFade10(this.tree,SubstanceLookAndFeel.TREE_DECORATIONS_ANIMATION_KIND) / 10.0f,
                            g));
        super.paintHorizontalPartOfLeg(graphics, clipBounds, insets,
                bounds, path, row, isExpanded, hasBeenExpanded, isLeaf);
        graphics.dispose();
    } else if (toPaint) {
        super.paintHorizontalPartOfLeg(g, clipBounds, insets, bounds, path,
                row, isExpanded, hasBeenExpanded, isLeaf);
    }
}