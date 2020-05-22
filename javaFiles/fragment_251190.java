JTable table = new JTable(model) {
    @Override
    public Component prepareRenderer(TableCellRenderer renderer,
            int row, int col) {

        Component c = super.prepareRenderer(renderer, row, col);
        if (col == PL_COLUMN) {
            Integer intValue = (Integer) getValueAt(row, col);
            c.setForeground(getColor(intValue));
        } else {
            c.setForeground(getForeground());
        }
        return c;
    }

    private Color getColor(int intValue) {
        Color color = null;
        if (intValue > 0) {
            color = Color.GREEN;
        } else if (intValue < 0) {
            color = Color.RED;
        } else {
            color = getForeground();
        }
        return color;
    }
};