PreparedStatement pstmt =
  conn.prepareStatement("update blob_table set blob = ? where id = ?");
File blob = new File("/path/to/picture.png");
FileInputStream in = new FileInputStream(blob);

// the cast to int is necessary because with JDBC 4 there is 
// also a version of this method with a (int, long) 
// but that is not implemented by Oracle
pstmt.setBinaryStream(1, in, (int)blob.length()); 

pstmt.setInt(2, 42);  // set the PK value
pstmt.executeUpdate();
conn.commit();
pstmt.close();