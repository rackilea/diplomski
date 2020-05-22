private static ConfigurableApplicationContext context;

@BeforeClass
public static void setUp() {
    context = new SpringApplicationBuilder(SimpleServiceApplication.class).run();
}

@AfterClass
public static void tearDown() {
    if (context != null) {
        context.close();
    }
}