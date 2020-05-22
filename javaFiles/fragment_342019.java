JTable table = new JTable(data, cols) {
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        Component c = super.prepareRenderer(renderer, row, col);
        if (col == IMPACT_COL) {
            c.setFont(IMPACT_FONT);
        } else if (col == ARIAL_COL) {
            c.setFont(ARIAL_BOLD_FONT);
        }
        return c;
    }
};