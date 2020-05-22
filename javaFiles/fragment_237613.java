@BeforeClass
public static void setup() throws IOException {
    System.setProperty("os.name.orig", System.getProperty("os.name"));

}

// other test case methods continue...

@AfterClass
public static void clearProperties() throws IOException {
    System.setProperty("os.name", System.getProperty("os.name.orig"));
    System.clearProperty("os.name.orig");
}