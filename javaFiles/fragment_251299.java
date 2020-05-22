class JToggleButtonRenderer extends JToggleButton implements TableCellRenderer {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null)
            return null;

        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }

        if (hasFocus) {
            // this cell is the anchor and the table has the focus
        }

        return (Component) value;
    }

    // The following methods override the defaults for performance reasons

    @Override
    public void validate() {}

    @Override
    public void revalidate() {}

    @Override
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}

    @Override
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}  
}