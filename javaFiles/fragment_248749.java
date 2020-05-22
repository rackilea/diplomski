int x = (Math.random() * 4);
int y = (Math.random() * 4);

board[x][y] = 1;
board[x + 1][y] = 1;
board[x][y + 1] = 1;
board[x + 1][y + 1] = 1;