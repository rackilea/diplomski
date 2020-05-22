//Board.grid[][] should be a 'Piece[8][8]';


//edit: rename parameters for clarity
public void move( Piece piece,int targetX,int targetY) 
{
  if( Board.getisnull(targetX, targetY) )//method in other class checks the indexes if null
  {
    //remove the piece from the field/index
    Board.grid[piece.x][piece.y]=null;

    //add the piece to the target field and update its position
    piece.x = targetX;
    piece.y = targetY;
    Board.grid[targetX][targetY]=piece;

  }
  else
  {
    //handle that case, e.g. by throwing an exeption
  }
}