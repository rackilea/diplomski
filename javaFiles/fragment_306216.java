public boolean fullSquare()
{
  int numcheck = 1;
  boolean found = false;
  while (numcheck < sq.length*sq.length)
  {
    for(int i = 0; i < sq.length;
      for(int j = 0; j < sq.length; j++)
        if(sq[i][j] == numcheck)
          found = true;

    if (!found)
      return false; //if the number wasn't found, it's not a full square
    found = false;
    numcheck++;
  }
    //use nested for loops to loop through array sq.
    //if the value in sq == numcheck, set found to true

    //After the loop, check to see if numcheck was found 
    //if not found, return false, otherwise set found to false
    //and increment numcheck to be ready to check the next number
  return true;
}