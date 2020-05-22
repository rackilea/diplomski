String sql="Select intime from employee where emp_id=? and date=?";
PreparedStatement statement=conn.prepareStatement(sql);
statement.setInt(1,1);
statement.setDate(2,java.sql.Date.valueOf("2012-06-25"));
ResultSet rs=statement.executeQuery();
if(rs.next())
 {
   //found
 }