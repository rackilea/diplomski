static {
    Properties prop = new Properties();
    InputStream input = DbConnection.class.getResourceAsStream("connection.properties");
    try {
        prop.load(input);
    } catch (IOException ex) {
        Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("exception " + ex);
    }

    String username = prop.getProperty("username");
    String password = prop.getProperty("password");

    properties[0] = username;
    properties[1] = password;

    System.out.println(properties[0]);
    System.out.println(properties[1]);
}