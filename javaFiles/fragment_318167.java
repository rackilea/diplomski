private static final class CustomPropRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final CustomProp prop = (CustomProp) value;
        final StringBuilder representation = new StringBuilder();
        //build a string representation of prop
        return super.getTableCellRendererComponent(table, representation.toString(), isSelected, hasFocus, row, column);
    }

}