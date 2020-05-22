public int getAverageColumnBlocks(Board board)
{
    int total = 0;
    for (int col = 0; col < Board.WIDTH; col++)
     {

      for (int row = 0; row < Board.HEIGHT; row++)
       {
          if(board.isBlockAt(col, row))
             {
                total++;
             }
       }

     }
    return total/Board.WIDTH;  
}