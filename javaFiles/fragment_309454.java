Properties prop = new Properties();
try {
    // load a properties file
    prop.load(new FileInputStream("src/main/resources/utility/config.properties"));

    // get the property value and print it out
    System.out.println(prop.getProperty("database"));
    System.out.println(prop.getProperty("dbuser"));
    System.out.println(prop.getProperty("dbpassword"));
} catch (IOException ex) {
    ex.printStackTrace();
}