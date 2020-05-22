public boolean Winner() {
    for (int z = 0; z < 3; z++) {
            if (board[z] != null && board[z] == board[z+3] && board[z] == board[z+6]
                    ) {
                return true;
            } 
    }
    for(int i=0; i<7;i+=3){
        if (board[i] != null && board[i] == board[i+1] && board[i] == board[i+2]) {

    return true;}
    }

    return false;
}