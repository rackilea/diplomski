String serverNew = serverName.getText();
String databaseNew = databaseName.getText();
String dbUsernameNew = databaseName.getText();
String dbPasswordNew = databasePassword.getText();  

Properties props = new Properties();
File f = new File("./jdbc.properties");
if (f.exists()) {
    props.load(new FileReader(f)); 
    props.setProperty("db.host", serverNew);
    props.setProperty("db.database", databaseNew);
    props.setProperty("db.username", dbUsernameNew);
    props.setProperty("db.password", dbPasswordNew);
    f.createNewFile(); 
} 

out = new FileOutputStream(f);
props.store(out, null);