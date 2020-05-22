private int getNumVisibleColumns(ListGrid grid) {
    int count = 0;
    for (ListGridField field : grid.getFields()) {
        if (grid.fieldIsVisible(field.getName())) {
            count++;
        }
    }
    return count;
}