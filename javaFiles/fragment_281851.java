try {
    // ...
    statement = connection.prepareStatement("select NAME from TABLE_NAME where FIELD=?");

    for ( /* 2M times? */ ) {
        statement.setInt(1, id);

        try {
            resultSet = statement.executeQuery();
            // ...
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
        }
    }
} finally {
    if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
}