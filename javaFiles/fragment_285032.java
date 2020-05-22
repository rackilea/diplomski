String driverName = "oracle.jdbc.driver.OracleDriver";
Class.forName(driverName);


String serverName = "localhost";
String mydatabase = "xe";
String url = "jdbc:oracle:thin:@//" + serverName + ":1521/" + mydatabase;