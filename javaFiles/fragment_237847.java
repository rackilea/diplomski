int[][] myBoard = {{1,1,1},{0,0,0},{1,1,1}};

for(int i = 0; i < myBoard.length; i++) {
    int count = 0;
    //Loop through the columns of the row
    for(int j = 0; j < myBoard[i].length; j++) {
        //Check to see if the column for this row is empty if it is add 
        //to our empty cell count
        if(myBoard[i][j] == 0) count ++;
    }

    //If our count is equal to the amount of columns in a row we return 
    //the row index.
    if(count == myBoard[i].length()) return i;
}