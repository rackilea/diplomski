private boolean isSurrounded(Cell type, Cell other) {
    for (int r = 0; r < size; r++) {
        for (int c = 0; c < size; c++) {
            if(board[r][c] == type){
                int count = 0;
                int win_count = 0;
                log(c + " " + r);
                if((r-1) >= 0 && (r - 1) < size){
                    win_count++;
                    if (board[r - 1][c] == other) {
                        count++;
                    }
                }

                if((r + 1) >= 0 && (r + 1) < size){
                    win_count++;
                    if (board[r + 1][c] == other) {
                        count++;
                    }
                }

                if((c + 1) >= 0 && (c + 1) < size){
                    win_count++;
                    if (board[r][c + 1] == other) {
                        count++;
                    }
                }

                if((c - 1) >= 0 && (c - 1) < size){
                    win_count++;
                    if (board[r][c - 1] == other) {
                        count++;
                    }
                }
                if(win_count == count){
                    return true;
                }
            }
        }
    }
    return false;
}