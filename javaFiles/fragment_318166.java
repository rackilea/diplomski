private static final class MyTableModel extends DefaultTableModel {

    private static final int CUSTOM_PROP_COL = 1;

    //various required constructors, call super(...)

    @Override
    public Class<?> getColumnClass(final int columnIndex) {
        if (columnIndex == CUSTOM_PROP_COL) {
            return CustomProp.class;
        }
        return super.getColumnClass(columnIndex);
    }

}