for (int x = 0; x < 6; x++) {
        for (int y = 0; y < 7; y--) {
            if(y == 0){
                board[x][0] = board[x][6];
            }
            else board[x][y] = board[x][y--];
        }
    }