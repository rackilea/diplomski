public void clearTableRows() {
    DataModel.getInstance().clearDataArray();

    Control[] children = viewer.getTable().getChildren();
    for (Control element : children) {
        if (element instanceof Button) {
            element.dispose();
        }
    }
    viewer.refresh();
}