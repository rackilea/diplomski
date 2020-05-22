@Before
public void createBoard() {
    Board.gameBoard = new int[][] { {0, 1, 1},
                                    {-1, 0, 1},
                                    {1, 0, -1} };
};

// and remove invocations of `createBoard()` in your test methods