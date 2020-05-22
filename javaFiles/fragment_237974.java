int row, column;
do
{
  row = (int)(3*Math.random());
  column = (int)(3*Math.random());
} while (!button[row][column].isEnabled()); // stop with the == boolean