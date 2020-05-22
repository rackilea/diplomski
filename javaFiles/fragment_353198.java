public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
{
        setText((String)value);
        setSize(table.getColumnModel().getColumn(column).getWidth(),getPreferredSize().height);
        setSelectionColor(Color.GREEN);

        if (isSelected)
        {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        }
        else
        {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        return this;
    }