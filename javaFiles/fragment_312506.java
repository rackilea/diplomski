private static DefaultRealm realm;

@BeforeClass
public static void initUI() {
    display = new Display();
    shell = new Shell(display);

    realm = new DefaultRealm();

    configPart = new ConfigPart();
    configPart.postConstruct(shell);
}

@AfterClass
public static void tearDownUI() {
    realm.dispose();
}