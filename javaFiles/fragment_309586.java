Properties p = hibernateConnection.getCfg().getProperties();

String url = p.getProperty("hibernate.connection.url");
String user = p.getProperty("hibernate.connection.username");
String password = p.getProperty("hibernate.connection.password");

DriverManager.getConnection(url, user, password).close();