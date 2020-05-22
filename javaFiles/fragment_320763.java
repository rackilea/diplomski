int size =0;
if (rs != null) 
{
  rs.last();    // moves cursor to the last row
  size = rs.getRow(); // get row id 
}