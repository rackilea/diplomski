scrollPane.skinProperty().addListener(c -> {
    ScrollBar hiddenScrollBar = (ScrollBar)scrollPane.queryAccessibleAttribute(AccessibleAttribute.VERTICAL_SCROLLBAR);
    if (hiddenScrollBar != null) {
        bar.visibleAmountProperty().bind(hiddenScrollBar.visibleAmountProperty());
        bar.blockIncrementProperty().bind(hiddenScrollBar.blockIncrementProperty());
        bar.unitIncrementProperty().bind(hiddenScrollBar.unitIncrementProperty());
    }
});