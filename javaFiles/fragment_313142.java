...
 pstmt.setString(12, temp.get(i).get(11).toString());
 pstmt.setString(13, temp.get(i).get(12).toString());
 pstmt.setString(14, temp.get(i).get(13).toString());
 pstmt.addBatch();
 if ((i + 1) % 100 == 0) {
      pstmt.executeBatch(); // Execute every 100 items.
 }