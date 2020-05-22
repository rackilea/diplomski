class Cell {

    int column;
    int row;
    Character letter;

    public Cell(int column, int row, Character letter) {
        this.column = column;
        this.row = row;
        this.letter = letter;
    }

    public boolean isEmpty() {
        return letter == null;
    }
}