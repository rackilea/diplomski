ResultSet rset = prepStatement1.executeQuery();
while(rset.next())
{
  String date = rset.getDate("date").toString();
  Float f = rset.getFloat("someFloat");
  System.out.println(date +" "+f);
}