Class.forName("com.mysql.jdbc.Driver");
Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:8889/test", "", "");
IDatabaseConnection con = new DatabaseConnection(jdbcConnection);

InputStream is = getClass().getClassLoader().getResourceAsStream("dbunit-test.xml");
IDataSet dataSet = new FlatXmlDataSetBuilder().build(is);
DatabaseOperation.CLEAN_INSERT.execute(con, dataSet);

con.close();