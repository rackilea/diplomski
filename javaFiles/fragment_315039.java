public void setBoard(int inBoard[][]){
        //GraphState = inBoard;
        for(int i=0; i<inBoard.length; i++)
              for(int j=0; j<inBoard[i].length; j++)
                GraphState[i][j]=inBoard[i][j];
}