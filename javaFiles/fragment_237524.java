DerbyPlatform dp = new DerbyPlatform();
dp.setDelimitedIdentifierModeOn(true);
Database dbs = new Database();
DerbyModelReader dmr = new DerbyModelReader(dp);
Database test = dmr.getDatabase(conn, "MyDBTest");

DerbyBuilder db = new DerbyBuilder(dp);
String testSqlDerby = dp.getCreateTablesSql(test, true, true);
System.out.println(testSqlDerby);

System.out.println("\n\n\n\n");

MySql50Platform mp = new MySql50Platform();
mp.setDelimitedIdentifierModeOn(true);
MySqlBuilder mb = new MySqlBuilder(mp);
String testSqlMysql = mp.getCreateTablesSql(test, true, true);
System.out.println(testSqlMysql);