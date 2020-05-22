while (input.hasNext()){ // use hasNext instead of hasNextInt
try{
    int column = input.nextInt();
    if (column < 0 || column > 6){
      errorWrongInput();
      continue;
    } 
} //Brackets required to close try
catch (InputMismatchException ex){ //catch Exception here for non integer input
            input.next(); // do a next() here
            continue;
        }
    if(placeCounter(board,column,player)) {
      if (hasWon(board)){
      System.out.println ("Player " +player+ " wins");
      printBoard(board);
      return;
      }
      player = playerTurn(player);
    }
  printBoard(board); // print the board
  }
}