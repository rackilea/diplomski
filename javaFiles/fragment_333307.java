ResultSet rs =  stmt.executeQuery(sql);
 int count = 0;
 if(rs.next())
 {
    count = rs.getInt(1);
  }