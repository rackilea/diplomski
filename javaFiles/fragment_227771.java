String sql = "UPDATE Buyer SET Name=?, latitude=?, longitude=? WHERE idBuyer=?";
try (PreparedStatement statement = conn.prepareStatement(sql)) {
    statement.setString(1, name);
    statement.setFloat(2, lat);
    statement.setFloat(3, lon);
    statement.setString(4, ID);
    statement.executeUpdate();
}