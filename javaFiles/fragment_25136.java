VectorTableCellRenderer renderer = new VectorTableCellRenderer();

    //set TableCellRenderer into a specified JTable column class
    table.setDefaultRenderer(Vector.class, renderer);

    //or, set TableCellRenderer into a specified JTable column
    table.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);