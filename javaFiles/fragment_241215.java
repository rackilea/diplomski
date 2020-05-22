public class Game {
  private int rows, columns;
  private int tileArr[][];

  ...

  public String toString(){
      StringBuilder builder = new StringBuilder();
      for(int i = 0; i < rows; i++){      
         for(int j = 0; j < columns; j++){ 
            builder.append( tileArr[i][j].toString() );
            builder.append(" "); // If tiles need to be separated.
         }   
         builder.append("\n");
      }
      return builder.toString();
   }
}