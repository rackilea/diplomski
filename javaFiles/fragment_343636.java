public class FilterEntry extends RowFilter.Entry<TableModel, Integer> {

    private final TableModel model;
    private final Object value;
    private final int rowIndex;

    public FilterEntry(TableModel model, Object value, int rowIndex) {

        this.model = model;
        this.value = value;
        this.rowIndex = rowIndex;

    }

    @Override
    public TableModel getModel() {

        return model;

    }

    @Override
    public int getValueCount() {

        return getModel().getColumnCount();

    }

    @Override
    public Object getValue(int index) {

        return value;

    }

    @Override
    public Integer getIdentifier() {

        return rowIndex;

    }

}