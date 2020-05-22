PreparedStatement insertPstmt = connection.prepareStatement("INSERT INTO MY_TABLE VALUES(?,?,?,?)");
PreparedStatement updatePstmt = connection.prepareStatement("UPDATE MY_TABLE, SET MY_VAL=? WHERE MY_VAL IS NULL");

While (<condition>) {
  If (<insert condition>) {
    // use insert pstmt and add batch
  } else {
    // use update pstmt and add batch
  }
}

insertPstmt.executeBatch(); 
updatePstmt.executeBatch();