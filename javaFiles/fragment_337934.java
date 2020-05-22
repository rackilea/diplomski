// use the Embedded Derby JDBC driver
Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

// connect to the database
Connection connect = DriverManager
            .getConnection("jdbc:derby:MyDBTest;create=true");

// execute a Query
PreparedStatement statement = connect
            .prepareStatement("SELECT * from USERS");
ResultSet resultSet = statement.executeQuery();
       :