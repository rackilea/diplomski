public View getTableLayoutCell(TableLayout layout, int rowNo, int columnNo) {
        if (rowNo >= layout.getChildCount()) return null;
        TableRow row = (TableRow) layout.getChildAt(rowNo);          

        if (columnNo >= row.getChildCount()) return null;
        return row.getChildAt(columnNo);

   }