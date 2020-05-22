public class Slot {
    private final IntegerProperty column = new SimpleIntegerProperty(this, "column");
    public IntegerProperty columnProperty() {
        return column ;
    }
    public final int getColumn() {
        return columnProperty().get();
    }
    public final void setColumn(int column) {
        columnProperty().set(column);
    }

    // similarly for row...

    public Slot(int column, int row) {
        column.addListener((obs, oldColumn, newColumn) -> 
            GridPane.setColumnIndex(getSlotContents(), newColumn.intValue()));
        // similarly for row
        setColumn(column);
        setRow(row);
    }

    // ...
}