public static class Shape {

    enum Tetrominoes { NoShape, ZShape, SShape, LineShape, TShape, 
        SquareShape, LShape, MirroredLShape 
    };

    private Tetrominoes pieceShape;
    private int coords[][];
    private int[][][] coordsTable;

    public Shape() {

        coords = new int[4][2];
        setShape(Tetrominoes.NoShape);
    }

    public void setShape(Tetrominoes shape) {

    }

}