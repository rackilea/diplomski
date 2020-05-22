class PathCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(
                        JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
        JLabel c = (JLabel)super.getTableCellRendererComponent( /* params from above (table, value, isSelected, hasFocus, row, column) */ );
        // This...
        String pathValue = <getYourPathValue>; // Could be value.toString()
        c.setToolTipText(pathValue);
        // ...OR this probably works in your case:
        c.setToolTipText(c.getText());
        return c;
    }
}

...
pathColumn.setCellRenderer(new PathCellRenderer()); // If your path is of specific class (e.g. java.io.File) you could set the renderer for that type
...