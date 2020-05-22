boolean rowIsConsecutive;
int previousValue;

for (int row = 0; row<list.length; row++) 
{
  rowIsConsecutive = true;
  previousValue = list[row][0]; // This will blow up with a 1D array. Just wrote it like this for readability. 

  for (int col = 1; col<list[row].length && rowIsConsecutive; col++) 
  {
    if (list[row][col] == previousValue + 1) 
    {
      previousValue = list[row][col];
    }
    else 
    {
      rowIsConsecutive = false;
    }
  }

  if (rowIsConsecutive)
  {
    System.out.println(Arrays.toString(list[row]));
  }
}