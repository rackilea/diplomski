PreparedStatement ps = conn.prepareStatement(
    "SELECT img FROM images WHERE imgname = ?"
);
ps.setString(1, "myimage.gif");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    byte[] imgBytes = rs.getBytes(1);
    // use the data in some way here
}
rs.close();
ps.close();