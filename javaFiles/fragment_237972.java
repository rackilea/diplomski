int row = (int)(2*Math.random())+1;
int column = (int)(2*Math.random())+1;
while (button[row][column].isEnabled()==false)
{
  row = (int)(2*Math.random())+1;
  column = (int)(2*Math.random())+1;
}