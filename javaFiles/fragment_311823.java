@BeforeClass
public static void setUpBeforeClass() throws Exception {
     /* set here the env. variables */
}

@Before
public void setUp() throws Exception {
    Bootstrap.startApplication(xmlFile); //launch the AUT
}