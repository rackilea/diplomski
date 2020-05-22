conn.setAutoCommit(false);  
PreparedStatement pStmt = conn.prepareStatement("INSERT INTO mytable (field1,field2) VALUES (?,?)");

for all values:
  pStmt.setString(1,val1);
  pStmt.setString(2,val2);
  pStmt.addBatch();    
  if ( i % 1000 == 0) {  
            pstmt.executeBatch();// Execute every 1000 items  
  } 
pstmt.executeBatch(); 
conn.commit();