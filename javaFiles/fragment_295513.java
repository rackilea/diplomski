class BoardButton extends JXButton {
  final private Game game;
  final private BoardCell cell;

  public BoardButton(Game game, int x, int y) { 
    this.game = game;
    this.cell = game.cellAtPiece(x,y);
  }

  public void refreshIcon() {
    if (cell.piece == null) { setIcon(null); }
    else if (cell.piece.owner != game.getCurrentPlayer()) { setIcon(hidden); }
    else setIcon(cell.piece.type.icon);
  }

  /* other utilities, like checking if a piece can be moved from here for current player and such */