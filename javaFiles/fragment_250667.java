private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

private static PrintStream outBackup;

@BeforeClass
public static void backupOut() {
    outBackup = System.out;
}

@Before
public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
}

@AfterClass
public static void cleanUpStreams() {
    System.setOut(outBackup);
}

@Test
public void out() {
    suma();
    assertEquals("4", outContent.toString());
}