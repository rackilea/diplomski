class CustomRenderer extends DefaultTableCellRenderer
{
    public CustomRenderer()
    {
        super();
        setHorizontalTextPosition(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        CustomObject custom = (CustomObject)value;
        setText( custom.getText() );
        setIcon( custom.getIcon() );

        return this;
    }
}