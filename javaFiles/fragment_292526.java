try {
    Connection connection = conn.getConnection();

    try {
        CallableStatement cStmt;

        connection.setAutoCommit(false);

        cStmt = connection.prepareCall(query);
        // ... register parameters ...

        try {
            cStmt.executeQuery();

            // ... extract and process SP out parameters ...

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            // ... other handling ...
        }
    } finally {
        connection.close();
    }
} catch (SQLException e) {
    // handle it ...
}