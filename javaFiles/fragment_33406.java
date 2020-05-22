public class Cell {
   private Piece currentPiece;
   public void setPiece(Piece currPiece){
          this.currentPiece = currPiece;
   }
   public String getCurrentPiece(){
          return this.currentPiece.getName();
   }