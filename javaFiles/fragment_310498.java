public String printTopTen()
{
   ScoreBoard board = new ScoreBoard(10); // new scoreboard with capacity of 10
   printTopTenRecur(this.root, board);
   return this.board.toString();
}