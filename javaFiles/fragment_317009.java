CellPane botTile = board[x][y];          
        if (botTile.getBackground().equals(Color.BLACK)){
            Color oldColor = botTile.getBackground; 
            board[x][y].setBackground(currentTile.getBackground());
            board[currentTile.getX()/50][currentTile.getY()/50].setBackground(oldColor);
        }