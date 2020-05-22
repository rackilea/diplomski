public static class MyCell extends ListCell<CellData> {
    private CellComponent cc;

    public MyCell() {
        cc = new CellComponent();
    }

    @Override
    protected void updateItem(CellData item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            cc.getTimer().textProperty().unbind();
            cc.getTimer().textProperty().bind(
                item.secondsRemainingProperty().asString("%.0f"));

            cc.getRect().widthProperty().unbind();
            cc.getRect().widthProperty().bind(
                item.secondsRemainingProperty().multiply(10));

            setText(null);
            setGraphic(cc.getCellPane());
        }
    }
}