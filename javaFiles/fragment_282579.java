JTable table = new JTable(tableModel) {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        int h = Math.min(N, table.getRowCount());
        return new Dimension(dim.width - 30, table.getRowHeight() * h);
    }
};