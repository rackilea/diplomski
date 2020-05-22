public void printTopTen()
{
    ScoreBoard board = new ScoreBoard(10); // new scoreboard with capacity of 10
    printTopTenRecur(this.root, board);
    System.out.println(this.board);
}