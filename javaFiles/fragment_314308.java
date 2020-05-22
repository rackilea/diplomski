public void displayable()
{
  int i,j;
  for (Row r: ar){
    i=0;
    for(String s: r){
        j=0;
        tableArray[i][j]=s;
        j++;
    }
    i++;
  }
}