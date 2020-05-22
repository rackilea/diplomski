for(i=0;i<9;i++)                                                        
        for(j=0;j<9;j++){
            if(board[i][j]==0){
                empty=true;
                break;
            }
        }
    if(!empty)return board;