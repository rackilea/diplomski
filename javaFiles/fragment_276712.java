// grid color
    jTable1.setGridColor(Color.BLUE);

    // columns resizable
    jTable1.getTableHeader().setResizingAllowed(true);

    // initial width of column 1
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);

    // height of al columns
    jTable1.setRowHeight(50);

    // height of column 2
    jTable1.setRowHeight(2, 25);