for (int y = 0; y < size; y++) {
          for (int x = 0; x < size; x++) {
            // Check where not equal
            if (initialBoard.grid[x][y] != newBoard.grid[x][y] && newBoard.grid[x][y] == 0) {
                // From move
                String from = x +""+ (char)y+65;
            }
            if(initialBoard.grid[x][y] != newBoard.grid[x][y] && newBoard.grid[x][y] != 0) {
                // To move
            }
          }
        }