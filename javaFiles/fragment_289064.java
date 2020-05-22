JTable table = new JTable(new AncientSwingTeam());
// the default renderer uses the table's font,
// so set it as appropriate
table.setFont(fontToUseForAllColumnsExceptFirst);
// a custom renderer which uses a special font
DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
    Font font = fontToUseForFirstColumn;

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        setFont(font);
        return this;
    }

};
// doesn't work because the default renderer's font is reset
// to the table's font always
// r.setFont(font);
// set the custom renderer for first column
table.getColumnModel().getColumn(0).setCellRenderer(r);