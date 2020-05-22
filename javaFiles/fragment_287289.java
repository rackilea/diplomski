if (line == null) return;
String query = "Insert into BigFile(text) values (?)";

try (
    Connection con = con = DriverManager.getConnection(...);
    PreparedStatement ps = con.prepareStatement(query);
){
    ps.setString(1, line);
    ps.executeUpdate();
} catch (SQLException sqle) {
    sqle.printStackTrace();
}