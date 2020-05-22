public void tableChanged(TableModelEvent e) {
    if (e == null || e.getFirstRow() == TableModelEvent.HEADER_ROW) {
        ...

        if (getAutoCreateColumnsFromModel()) {
    // This will effect invalidation of the JTable and JTableHeader.
            createDefaultColumnsFromModel();
    return;
    }
        ...