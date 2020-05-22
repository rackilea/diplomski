class Game {
  Board board;
  Player[] players = new Player[2];
  Player currentPlayer;

  Player getCurrentPlayer() { return currentPlayer; }
  /* other methods, eg turn advance, check for correct position, eat piece etc */
}