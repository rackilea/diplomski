Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet generatedKeys = null;

    try {
        connection = m_Connection;
        preparedStatement = (PreparedStatement) connection.prepareStatement(qString, Statement.RETURN_GENERATED_KEYS);

        // ...

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        generatedKeys = preparedStatement.getGeneratedKeys();
        int id = -1;
        if (generatedKeys.next()) {
            id = generatedKeys.getInt(1);
            id = -1;
        } else {
            throw new SQLException("Creating user failed, no generated key obtained.");
        }
    } finally {

    }