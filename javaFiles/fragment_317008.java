Int x = currentTile.getX()/50;
        int y = (currentTile.getY()+1)/50;

        CellPane botTile = board[x][y];
        if (botTile.getBackground().equals(Color.BLACK)){
            board[x][y].setBackground(currentTile.getBackground());
            board[currentTile.getX()/50][currentTile.getY()/50].setBackground(botTile.getBackground());
        }