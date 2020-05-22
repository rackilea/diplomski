public static class Cell {
    public int row;     
    public int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;         
    }

    @Override
    public String toString() {
        return "{" + row + ", " + col + "}";
    }
}