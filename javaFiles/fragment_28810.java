private final static String username = getData("username"); // ERROR HERE
private static Properties prop;
// more variables

static {
    prop = new Properties();
    try {
        FileInputStream fis = new FileInputStream("MyDB.properties");
        prop.load(fis);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}