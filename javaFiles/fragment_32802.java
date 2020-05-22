String query1 = "INSERT INTO user (firstName, lastName, belonging, country)"
        + " VALUES(?,?,?,?)";
String query2 = "INSERT INTO authentication (address, password, user_id, login_id)"
        + " VALUES(?,?,?,?)";
try (PreparedStatement stmt1 = this.dbConn.prepareStatement(query1,
                PreparedStatement.RETURN_GENERATED_KEYS);
        stmt2 = this.dbConn.prepareStatement(query2)) {
    stmt1.setString(1, "default");
    stmt1.setString(2, "default");
    stmt1.setString(3, "default");
    stmt1.setString(4, "default");
    stmt1.executeUpdate();
    try (ResultSet rs = stmt1.getGeneratedKeys())  {
        if (rs.next()) {
            int userid = rs.getInt(1);
            stmt2.setString(1, "default");
            stmt2.setString(2, password);
            stmt2.setInt(3, key);
            stmt2.setString(4, userid);
            stmt2.executeUpdate();
            return true;
        }
    }
} catch (SQLException e) {
    System.err.println(e.getMessage());
}
return false;