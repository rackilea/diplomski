public void removeRecord(int row) throws SQLException {
    String deleteQuery = "delete from mytable where id=?";
    PreparedStatement statement = connection.prepareStatement(deleteQuery);
    statement.setInt(1, row);
    int rowsAffected = statement.executeUpdate();
}