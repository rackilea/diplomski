public boolean rowAndColumn(int tN)
{
  int rowsum = 0, colsum = 0;
  for(int i = 0; i < sq[0].length; i++)
  {
    for(int j = 0; j < sq[0].length; j++)
    {
      rowsum = rowsum + sq[i][j];
      colsum = colsum + sq[j][i];
    }
    if(rowsum != tN || colsum != tN)
      return false; //no point checking the rest if the sums doesn't match
    rowsum = 0; //reset row count
    colsum = 0; //reset col count
  }
  return true; //if it doesn't return by here, all the sums match
}