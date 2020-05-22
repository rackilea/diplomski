int count =0;
        for(int i=0;i<4;i++) {
            for(int j=0; j<4;j++) {
                if((board[i][j]== 13 || board[i][j]== 26 || board[i][j]== 39 || board[i][j]== 52 ) && board[i][j+1]==0 ) {
                    count += numberOfZeros(i, j);
                }
            }
        }
        while(count <4) {
            move(board);
        }
    }

    public int numberOfZeros(int i, int j){

        int aux = 0;
        for(; j<4;j++) {
            if(board[i][j] == 0){
                aux++;
            }
        }
        return aux;
    }