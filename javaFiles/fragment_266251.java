List<Brick> bricks = new ArrayList<Brick>();

public ChessBoard() {

    setSize(800,800);
    setLayout(new GridLayout(BRICKS/ ROWS, 0) );

    for (int id = 0; id < BRICKS; id++) {
        Brick brick = new Brick(id);        
        add(brick); 
        bricks.add(brick);
    }

    setVisible(true);

}

public void setBrick(int id, int piece) {
    bricks.get(id).setPiece(piece);
}