private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
  private static final String DB_CONNECTION = "jdbc:oracle:thin:@//host:1526/databasename";
private static final String DB_USER = "username";
private static final String DB_PASSWORD = "passowrd";

public static Connection lockConnection() {

    Connection dbConnection = null;

    try {

        Class.forName(DB_DRIVER);

    } catch (ClassNotFoundException e) {

        System.out.println(e.getMessage());

    }

    try {

        return DriverManager.getConnection(
                DB_CONNECTION, DB_USER, DB_PASSWORD);



    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return dbConnection;

}
public static void closeMyConnection(Connection connection) {

    try {

        connection.close();


    } catch (Exception ex) {
        ex.printStackTrace();
    }

}