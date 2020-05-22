public void addNeigbors(int x, int y)
{
  Cell curentCell=grid[x][y];
  int xp1 = (x+1)%width;
  int xm1 = (x-1+width)%width;
  int yp1 = (y+1)%height;
  int ym1 = (y-1+height)%height;
  curentCell.addNiegbor(this.cells[xp1][y]);
  curentCell.addNiegbor(this.cells[xp1][yp1]);
  curentCell.addNiegbor(this.cells[xp1][ym1]);
  curentCell.addNiegbor(this.cells[x][yp1]);
  curentCell.addNiegbor(this.cells[x][ym1]);
  curentCell.addNiegbor(this.cells[xm1][y]);
  curentCell.addNiegbor(this.cells[xm1][yp1]);
  curentCell.addNiegbor(this.cells[xm1][ym1]);
}