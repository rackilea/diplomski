Class.forName("org.apache.hive.jdbc.HiveDriver");
Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "hive", "");
Statement stmt = con.createStatement();
String tableName = "testHiveDriverTable";
stmt.execute("drop table if exists " + tableName);
stmt.execute("create table " + tableName + " (key int, value string)");
String sql = "show tables '" + tableName + "'";