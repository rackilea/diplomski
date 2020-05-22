// use the Derby JDBC driver
Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

// connect to the database
Connection connect = DriverManager
            .getConnection("jdbc:derby://localhost/c:/temp/db/FAQ/db");

// execute a Query
PreparedStatement statement = connect
            .prepareStatement("SELECT * from USERS");
ResultSet resultSet = statement.executeQuery();
       :