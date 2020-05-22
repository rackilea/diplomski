Statement stmt = dbconx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {
  // do stuff
}
// when finished you can reuse the ResultSet by calling beforeFirst()
rs.beforeFirst();

while (rs.next()) {
  // do more stuff
}
rs.beforeFirst();
// etc.