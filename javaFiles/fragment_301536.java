Connection con = ...get Connection...
con.setAutoCommit(false);
PreparedStatement ps = con.prepareStatement("SELECT * FROM table ORDER BY columm");
ResultSet rs = ps.executeQuery();
while(rs.next()) {
    String col1 = rs.getString(1);
    ...and away you go here...
}
rs.close();
ps.close();
con.close();