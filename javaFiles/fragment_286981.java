public class DatasourceConfig {

/**
 * Setup info came from: http://www.avaje.org/ebean/getstarted_programmatic.html
 */
public void init() {
    ServerConfig serverConfig = new ServerConfig();
    serverConfig.setName("derby");

    //Define datasource parameters
    DataSourceConfig derbyDb = new DataSourceConfig();  
    derbyDb.setDriver("org.apache.derby.jdbc.ClientDriver");  
    derbyDb.setUsername("");  
    derbyDb.setPassword("");  
    derbyDb.setUrl("jdbc:derby:/home/the_ox/dev/servers/derby-db/game/;");  
    derbyDb.setHeartbeatSql("select 1");  
    serverConfig.setDataSourceConfig(derbyDb);  

    // set DDL options...  
    serverConfig.setDdlGenerate(false);  
    serverConfig.setDdlRun(false);  

    serverConfig.setDefaultServer(true);

    //Setup derby specific identity 'stuff'.
    DatabasePlatform dbPlatform = new DatabasePlatform();
    dbPlatform.getDbIdentity().setIdType(IdType.IDENTITY);
    dbPlatform.getDbIdentity().setSupportsGetGeneratedKeys(true);
    dbPlatform.getDbIdentity().setSupportsSequence(false);
    dbPlatform.getDbIdentity().setSupportsIdentity(true);
    serverConfig.setDatabasePlatform(dbPlatform);

    //Specify jar to search for entity beans
    serverConfig.addJar("engine-0.0.1-SNAPSHOT.jar");

    // create the EbeanServer instance  
    EbeanServer server = EbeanServerFactory.create(serverConfig);  
}

}