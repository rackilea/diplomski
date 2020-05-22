Figure get(int hor, int vert) {
  return board[hor*8+ver];
}

void set(int hor, int vert, Figure f) {
  board[hor*8+ver] = f;
}