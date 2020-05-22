public class TableCellCustom <S, T> extends TableCell<S, T> {

    // the type of T:
    private final Class<T> type ;

    String colname;

    public TableCellCustom (String colname, Class<T> type) {
        this.colname = colname;
        this.type = type ;
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            setConditionalFormatting(this, item);
        }
    }

    public void setConditionalFormatting (TableCell<S,T> cell, T item) {
        //perform specific cell formatting....
        if (type == Date.class) {
            // ...
        } else {
            // ...
        }
    }
}