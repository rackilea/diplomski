private void scrollToLast() {
    if (isAutoScroll) {
        int last = table.getModel().getRowCount() - 1;
        Rectangle r = table.getCellRect(last, 0, true);
        table.scrollRectToVisible(r);
    }
}