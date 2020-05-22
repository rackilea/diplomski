while (mines>0){                          
        row=rng.nextInt(NUM_OF_ROWS);
        col=rng.nextInt(NUM_OF_CL);
        if ((gameboard[row][col])!=19){
            gameboard[row][col]+=9;;
            minesleft--;
        }
    }