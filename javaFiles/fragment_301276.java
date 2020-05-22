ResultSet rs = ps.getGeneratedKeys();
ps = conn.prepareStatement("INSERT INTO TABLE_B (B_ID, B_DESCRIPTION) VALUES (?, ?)");

for ( int counter =0;rs.next(); counter++ ) { 
  ps.setInt(1,rs.getInt(0));
  ps.setString(2, myCollection.get(counter).getDescription());
  ps.addBatch();
}
...