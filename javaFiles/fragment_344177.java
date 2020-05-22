int N = board.length*board.length;
char[] board1D = new char[N];

int k = 0;
for (int i =0; i<board.length; i++) {
    for (int j =0; j<board.length; j++) {
      board1D[k++] = board[i][j];
    }
}