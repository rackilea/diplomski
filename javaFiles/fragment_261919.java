protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.actity_layout);
    board = new Board();
    boardView = new BoardView(this, board);
    board.addObserver(boardView);
    LinearLayout boardgame = (LinearLayout)  findViewById(R.id.boardgame);
    linBoardGame.addView(boardview);
}