public class CustomCellRenderer  implements TableCellRenderer {
    //Use appropriate class here
    private final TableCellRenderer defaultTableCellRenderer= new JTable().getDefaultRenderer(Object.class);
    @Override
    public Component getTableCellRendererComponent(
              JTable table, Object value, boolean isSelected, boolean hasFocus,
              int row, int column) {
        Component c = defaultTableCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // do custom stuff to c here ...
        return c;
    }
}