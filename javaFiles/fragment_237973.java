int row = (int)(3*Math.random());
int column = (int)(3*Math.random());
while (button[row][column].isEnabled()==false)
{
  row = (int)(3*Math.random());
  column = (int)(3*Math.random());
}