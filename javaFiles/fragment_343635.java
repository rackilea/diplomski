public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

    RowFilter rowFilter = ((TableRowSorter) table.getRowSorter()).getRowFilter();
    if (rowFilter != null) {

        if (!rowFilter.include(new FilterEntry(table.getModel(), value, row))) {

            value = null;

        }

    }

    // The rest of the code...

}