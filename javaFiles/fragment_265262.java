private int cX=0;
  private int cY=0;


  //Randomly set coordinates on the array. 
 for(int i=0; i<1; i++){
  int x = randGen.nextInt(9);
  int y = randGen.nextInt(9);
  if (board [x][y].display()=='.'){
   CX=x;
   CY=y;
  }
 }  


 //Print array
private void displayArray(){
 for (int i = 0; i < board.length; i++){ 
  for (int j = 0; j < board[i].length; j++){
   if ((i==CX)&&(j==CY))
    System.out.print("C"+"\t");
   else
    System.out.print(board [i][j].display()+"\t");
  }
 System.out.println("\n");
 }
}