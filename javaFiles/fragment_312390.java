Driver driver = new Driver(hiveConf);
HiveMetaStoreClient client = new HiveMetaStoreClient(hiveConf);
SessionState.start(new CliSessionState(hiveConf));
driver.run("select  * from employee);
// DDL example
client.dropTable(db, table);