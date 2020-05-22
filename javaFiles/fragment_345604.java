// This will load the MySQL driver, each DB has its own driver
  Class.forName("com.mysql.jdbc.Driver");
  // Setup the connection with the DB
  connect = DriverManager
      .getConnection("jdbc:mysql://remoteUri/database-name?"
          + "user=user&password=userpw");