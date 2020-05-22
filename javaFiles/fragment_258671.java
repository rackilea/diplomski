ResultSet rs=stmt.executeQuery("select * from customer");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString("2")+"  ");  
//1  I removed from your code `rs.getString(3)` and `rs.getString(2)`
//2  You can add string as rs.getString("3"), `rs.getString("2")` like this 
//3 my suggestion is you first remove rs.getString(3) , rs.getString("2") and run