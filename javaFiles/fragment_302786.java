private String row;

public String getRow()
{
   return row;
}

public void setRow(String row)
{
   this.row = row;
}

private boolean validateRow(String row)
{
  if(isInteger())
    {
      // check the given value as int or Integer.
      return true;
    }
  // show the message invalid
  return false;
}