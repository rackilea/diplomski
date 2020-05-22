public static final String DEFINED_KEY = "definedKey";
public static final String DEFINED_PROPERTY = "definedProperty";

public void run() throws Exception {
    // your code
    File f = File.createTempFile("default", ".properties");
    PrintWriter pw = new PrintWriter(f);
    Properties pp = new Properties();
    pp.setProperty(DEFINED_KEY, DEFINED_PROPERTY);
    pp.store(pw, "Automatically defined");
    pw.close();

    // examining the generated properties file
    System.out.println("Reading from properties file...");
    System.out.println("------------");
    Scanner scanner = new Scanner(f);
    while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
    }
    System.out.println("------------");

    // loading properties file
    Properties p = new Properties();
    p.load(new FileInputStream(f));

    System.out.println("p.get(DEFINED_KEY): " + p.get(DEFINED_KEY));
    System.out.println("p.getProperty(DEFINED_KEY): " + p.getProperty(DEFINED_KEY));
}