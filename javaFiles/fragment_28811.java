private static Properties prop = new Properties();
private final static String username = getData("username"); 

static {

    try {
        FileInputStream fis = new FileInputStream("MyDB.properties");
        prop.load(fis);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}