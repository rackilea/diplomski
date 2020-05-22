Statement s = conn.createStatement ();
s.executeQuery ("SELECT id, name FROM user");
ResultSet rs = s.getResultSet();
rs = statement.executeQuery();
while (rs.next()) {
    int id = resultSet.getInt("id");
    int name = resultSet.getInt("name");
    // ...
}