if(actualState == GameState.JOUE){
        if((selectedRow >= 0) && (selectedRow < ROWS) && (selectedCol >= 0)
                && (selectedCol < COLS) &&
                (board[selectedRow][selectedCol] == Token.VIDE)){
            board[selectedRow][selectedCol] = actualPlayer;
            //actualiseJeu(actualPlayer, selectedRow, selectedCol);
            actualPlayer = (actualPlayer == Token.CERCLE_BLEU)? Token.CERCLE_ROUGE : Token.CERCLE_BLEU;

            //add this to call function : 
            neighbours(selectedCol, selectedRow);
        }
    }