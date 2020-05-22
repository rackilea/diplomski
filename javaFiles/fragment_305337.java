Connection dbConnection = null;
    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO DBUSER"
            + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
            + "(?,?,?,?)";

    try {
        dbConnection = getDBConnection();
        preparedStatement = dbConnection.prepareStatement(insertTableSQL);

        dbConnection.setAutoCommit(false);

        preparedStatement.setInt(1, 101);
        preparedStatement.setString(2, "mkyong101");
        preparedStatement.setString(3, "system");
        preparedStatement.setTimestamp(4, getCurrentTimeStamp());
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 102);
        preparedStatement.setString(2, "mkyong102");
        preparedStatement.setString(3, "system");
        preparedStatement.setTimestamp(4, getCurrentTimeStamp());
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 103);
        preparedStatement.setString(2, "mkyong103");
        preparedStatement.setString(3, "system");
        preparedStatement.setTimestamp(4, getCurrentTimeStamp());
        preparedStatement.addBatch();

        preparedStatement.executeBatch();

        dbConnection.commit();

        System.out.println("Record is inserted into DBUSER table!");

    } catch (SQLException e) {

        System.out.println(e.getMessage());
        dbConnection.rollback();

    } finally {

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (dbConnection != null) {
            dbConnection.close();
        }

    }