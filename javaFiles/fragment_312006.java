for(int i = 0;i<4;i++) {
//i - index of a row, we have 4 rows so we want to loop through all of them
        for (int j = 0; j < 4; j++) {
        //j - position of an element in that row, every row has 4 positions so we want to
        //loop through all of them on every row
            if(gameBoard[i][j] == 2){
                //draw something at i,j coordinates
                //example:
                canvas.drawRect(j * 50, i * 50, (j + 1) * 50, (i + 1) * 50, new Paint());
            }
        }
    }