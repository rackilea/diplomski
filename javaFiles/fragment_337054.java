public static int MAX_DEPTH = 10;

static Integer[][] matrix;
static Coord[] directions = {
    new Coord(-1, 0),
    new Coord(1, 0),
    new Coord(0, -1),
    new Coord(0, 1)
};

private static class Coord {
    int row;
    int col;

    private Coord(int row, int col) {
        this.col = col;
        this.row = row;
    }

    private Coord newPosition(Coord relative) {
        return new Coord(row + relative.row, col + relative.col);
    }
}