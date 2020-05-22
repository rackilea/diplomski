// Writing an object to a database
PreparedStatement pstmt = conn.prepareStatement("insert into MY_USER_TABLE values(?,?)");
pstmt.setInt(1, 1);
pstmt.setObject(2, new MyUser("Alice", "aAddress", "111-1111"));
pstmt.addBatch();
pstmt.executeBatch(); // Insert the users
pstmt.close();

// Reading an object from a database
Statement stmt = conn.createStatement();
stmt.execute("select * from MY_USER_TABLE");
ResultSet rs = stmt.getResultSet();
rs.next();
MyUser userFromDB = rs.getObject(2, MyUser.class);
rs.close();
stmt.close();