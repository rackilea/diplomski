public static ArrayList<String> newBoard() {
    ArrayList<String> board = new ArrayList<String>(8);
    for (int i = 0; i < 9; i++)
        board.add("");
    return board;
}