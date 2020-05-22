AbstractHighlighter highlighter = new AbstractHighlighter(HighlightPredicate.EVEN) {

    @Override
    protected Component doHighlight(Component component,
            ComponentAdapter adapter) {
        ((WrappingIconPanel) component).getComponent().setVisible(false);
        return component;
    }

    @Override
    protected boolean canHighlight(Component component,
            ComponentAdapter adapter) {
        return component instanceof WrappingIconPanel;
    }


};
table.addHighlighter(highlighter);