String sql = "INSERT INTO studenten (id, naam, adres, postcode, plaats, geboren)"
     + " VALUES (?, ?, ?, ?, ?, ?)";
Connection connection = null;
PreparedStatement statement = null;

try {
    connection = database.getConnection();
    statement = connection.prepareStatement(sql);
    statement.setLong(lastId + 1); // Why don't you use an generated sequence? This is plain ugly and errorprone.
    statement.setString(contact.getNaam());
    statement.setString(contact.getAdres());
    statement.setString(contact.getPostcode());
    statement.setString(contact.getPlaats());
    statement.setDate(new java.sql.Date(contact.getGeboren().getTime())); // Assuming it returns java.util.Date
    statement.executeUpdate();
} finally {
    // Always close in finally to prevent resource leaks.
    if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
    if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
}