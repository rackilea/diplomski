node n = field[i][j];
if (n == null) { // initialize n at the position if it doesn't exist
  n = new node();
  field[i][j] = n;
}

field[i][j].setF(f);