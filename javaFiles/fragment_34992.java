public void queryFromDb() {

    Statement queryStatement = null;
    PreparedStatement insertStatement = null;

    try {
        queryStatement = connection.createStatement();
        insertStatement = connection.prepareStatement(
                             "INSERT INTO cls rck VALUES 2");

        ResultSet rs = queryStatement
                .executeQuery("SELECT * FROM clsbck ORDER BY id");

        while (rs.next()) {
            System.out.println(rs.getString(2));
            // [...]
            insertStatement.executeUpdate();
        }
        rs.close();
    } catch (SQLException e) {
        printSQLException(e);
    } finally {
        if (queryStatement != null) {
            queryStatement.close();
        }
        if (insertStatement != null) {
            insertStatement.close();
        }
    }
}