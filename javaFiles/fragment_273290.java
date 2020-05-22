String dbUri = System.getenv("DATABASE_URL");
Class.forName("org.postgresql.Driver");
String username = dbUri.getUserInfo().split(":")[0];
String password = dbUri.getUserInfo().split(":")[1];
String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath() + "?user=" + username + "&password=" + password;
Connection connection = DriverManager.getConnection(dbUrl);

InputStreamReader inputStreamReader = new InputStreamReader(ClassLoader.getSystemResourceAsStream(sqlFile));

Reader reader = new BufferedReader(inputStreamReader);

ScriptRunner scriptRunner = new ScriptRunner(connection, false, true);
scriptRunner.runScript(reader);