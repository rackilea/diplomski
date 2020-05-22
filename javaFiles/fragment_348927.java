Connection dbConn = template.getDataSource().getConnection();

    IDatabaseConnection connection = new DatabaseConnection(dbConn, "UTEST", false);

    DatabaseConfig dbConfig = connection.getConfig();

    // added this line to get rid of the warning
    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());