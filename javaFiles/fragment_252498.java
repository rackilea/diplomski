Connection connection;

String dburl = "jdbc:mysql://localhost/YOUR_DATABASE_NAME";
String user = "YOUR_USER_NAME";     //this is by default 'root' in wamp
String password = "YOUR_PASSWORD";  //this is by default blank in wamp
//following line will establish the connection
connection = DriverManager.getConnection(dburl, user, password);

//You can use following method to retrieve data from the database tables.

Statement statement = connection.createStatement();
String query = "SELECT * FROM YOUR_TABLE_NAME";
//Below line will return resultset of the select query. it is a kind of array set.
ResultSet result = statement.executeQuery(query);

if(connection != null)
      connection.close();