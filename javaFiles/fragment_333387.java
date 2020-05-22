Properties prop = new Properties();

try {
    // load a properties file
    prop.load(YourClass.class.getResourceAsStream("/jdbc.properties")); // note the leading /

    System.out.println(prop.getProperty("password"));

} catch (IOException ex) {
    ex.printStackTrace();
}