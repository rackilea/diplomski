String path = Utils.getPathOfJar();    
path = path.jarFilePath.replaceAll("%20", "\\ ");
System.setProperty("derby.system.home", path);

public static final String connectionUrl = "jdbc:derby:database;user=app;password=pass;";
dbConnection = DriverManager.getConnection(connectionUrl);