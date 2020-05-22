class ColorRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected)
        {
            int viewColumn = convertColumnIndexToView(1)
            String value = getModel().getValueAt(rowIndex, viewColumn).toString();

            if ("Online".equalsIgnoreCase(value))
                setBackground( Color.GREEN );
            else
                setBackground( Color.lightgray );

            return this;
        }
    }
}