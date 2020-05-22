class Grid {

    private Cell[][] cells = new Cell[9][9];
    {
        for (int i = 0; i<cells.length; i++){
            for (int j = 0; j<cells[i].length; j++){
                cells[i][j] = new Cell();//lets use no-argument constructor
            }
        }
    }

    public void setCell(int row, int column, Integer value){
        cells[row][column].setValue(value);
    }

}