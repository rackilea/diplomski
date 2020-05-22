private boolean checkLines(int x, int y, int value) {
  for (int i = 0; i <= 9; i++) {
    if (this.gridPlayer[x][i].getValue() == value) return false;
     else return true;
  }
 return false; //even if you think it will never be run it is necessary 
}