private boolean selectAll;

public void onSelectAll(AjaxBehaviorEvent event) {
    // If you're using a boolean property on the row object.
    for (Item item : list) {
        item.setSelected(selectAll);
    }

    // Or if you're using a Map<Long, Boolean> on item IDs
    for (Entry<Long, Boolean> entry : selected.entrySet()) {
        entry.setValue(selectAll);
    }
}

public boolean isSelectAll() {
    return selectAll;
}

public void setSelectAll(boolean selectAll) {
    this.selectAll = selectAll;
}