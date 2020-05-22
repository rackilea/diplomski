public class CustomCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>>  {

    String colname;
    boolean editable;

    private final Class<T> type ;

    public CustomCellFactory (String colname, boolean editable, Class<T> type) {
        this.colname = colname;
        this.editable = editable;
        this.type = type ;
    }

    @Override
    public TableCell<S, T> call(TableColumn<S, T> arg) {
        TableCell<S, T> cell;
        if (editable == true) {
            cell = new TableCellEditable<>(colname);
        } else {
            cell = new TableCellCustom<>(colname, type);
        }
        return cell;
    }

}