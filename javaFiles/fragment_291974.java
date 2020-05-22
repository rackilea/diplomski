private class HighlightRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        // everything as usual
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // added behavior
        if (value!=null && value.toString().matches(".*"+Pattern.quote(text)+".*")) {

            // this will customize that kind of border that will be use to highlight a row
            setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        } else
            setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1);

        return this;
    }
}