public void setModel() {
    String[] str = new String[col];    <--- contains the name of each column
    Cell[][] obj = new Cell[row][col]; <--- 2d array for every table cell (Cell is an own class)

    for (int i = 0; i < row; i++) {    <--- init the cells (row and col containing the size of the table)
        for (int j = 0; j < col; j++) {
            obj[i][j] = new Cell(i, j);
            str[j] = new String("");
        }
    }

    table.setModel(new DefaultTableModel(obj, str)); <--- set the model for the table
}