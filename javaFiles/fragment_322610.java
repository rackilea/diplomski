int numRows = /* number of rows in table variable */;

    StringBuilder sqlBuilder = new StringBuilder("DECLARE @Location AS LocationType;");
    for (int i = 0; i < numRows; ++i) {
        sqlBuilder.append(
            "INSERT INTO @Location (OrganizationSubID, LocationCode) VALUES (?, ?);");
    }

    sqlBuilder.append("EXEC [Organization].[Organization_Insert] ?, @Location;");

    PreparedStatement stmt = connection.prepareStatement(sqlBuilder.toString());
    for (int i = 0; i < numRows; ++i) {
        stmt.setString(i * 2 + 1, /* OrganizationSubID for row i */);
        stmt.setString(i * 2 + 2, /* LocationCode for row i  */);
    }

    stmt.setString(numRows * 2 + 1, /* Organization ID */);

    ResultSet resultSet = stmt.executeQuery();
    resultSet.close();