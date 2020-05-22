public class BigDecimalEditingCell extends TableCell {

    private BigDecimalField element = new BigDecimalField(new BigDecimal("0.00"));
    private ObjectProperty<BigDecimal> campoLigado = null;

    @Override
    protected void updateItem(Object item, boolean empty) {
        super.updateItem(item,empty);
        if (getIndex() < getTableView().getItems().size() && !empty) {
            createField();
            createBind();
            setGraphic(element);
            setText(null);
        } else {
            removeBind();
            setGraphic(null);
        }
    }

    .
    .
    .
}