static final Properties properties = new Properties();

static {
    /************ File properties configuration ***************/
    // Get the inputStream
    final InputStream inputStream =
            SeleniumTest.class.getResourceAsStream("messages_fr.properties");
    System.out.println("InputStream is: " + inputStream);
    // load the inputStream using the Properties
    properties.load(inputStream);
    /*********** End configuration properties file **************/
}