//assuming con (DB connection) is properly setup
 final PreparedStatment statement = con.prepareStatement(sql); 
 statement.setString(1, "X1DEL");
 statement.setString(2, "CHAR");
 statement.setInt(3,1);
 statement.setInt(4, 2);

 //... etc