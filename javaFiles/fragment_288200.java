public class DateCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean selected, boolean hasFocus, int row, int column) {

        if (value instanceof Date) {

            // You could use SimpleDateFormatter instead
            value = DateFormat.getDateInstance().format(value);

        }


        return super.getTableCellRendererComponent(jtable, value, selected, hasFocus, row, column);

    }