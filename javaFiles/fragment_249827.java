public static class CellIndex {
    int row;  
    int col;
    public CellIndex(int row, int col) {
        this.row = row;
        this.col = col;
    }
    // getters, etc.
}
...
public CellIndex mapPositionToIndex(String position) {
    int col = (int)(position.charAt(0) - 'a');
    int row = (int)(position.charAt(1) - '1');
    return new CellIndex(row,col);
}