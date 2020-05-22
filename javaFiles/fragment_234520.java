ResultSet rs1= stmt.executeQuery(queryPhotoid);    

while (rs1.next())  {

  System.out.println("ranu"+rs1.getString(6));  
  if(id.equals(rs1.getString(6)))
  {
  // blah blah..
  }
//blah
}