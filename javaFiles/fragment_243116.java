PreparedStatement stmt = con.prepareStatement("update tst set txt = ? where id = ?");
5.times { i ->
  stmt.setString(1, "''''''''");
  stmt.setInt(2, i+1);
  stmt.addBatch();
}

// submit a batch of update commands for execution
int[] updateCounts = stmt.executeBatch();