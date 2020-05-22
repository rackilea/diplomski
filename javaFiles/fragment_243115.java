Statement stmt = con.createStatement();

stmt.addBatch("update tst set txt = q'['''''''']' where id = 1");
stmt.addBatch("update tst set txt = q'['''''''']' where id = 2");
stmt.addBatch("update tst set txt = q'['''''''']' where id = 3");
stmt.addBatch("update tst set txt = q'['''''''']' where id = 4");
stmt.addBatch("update tst set txt = q'['''''''']' where id = 5"); 
// submit a batch of update commands for execution
int[] updateCounts = stmt.executeBatch();