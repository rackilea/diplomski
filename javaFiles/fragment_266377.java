import oracle.jdbc.OracleConnection;    

//Declare variables
String url = "...";
String username = "...";
String password = "...";

//Create the Connection
Connection conn = DriverManager.getConnection(url, username, password);

//Set the proxy properties
java.util.Properties prop = new java.util.Properties();
prop.put(OracleConnection.PROXY_USER_NAME, "BILL");
prop.put(OracleConnection.PROXY_USER_PASSWORD, "password");

//Cast the Connection to an OracleConnection and create the proxy session
((OracleConnection)conn).openProxySession(OracleConnection.PROXYTYPE_USER_NAME, prop);

/* The Connection credentials have now been changed */