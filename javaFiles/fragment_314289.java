static MongodExecutable mongodExecutable;

@BeforeClass
public static void setup() throws Exception {
    MongodStarter starter = MongodStarter.getDefaultInstance();
    String bindIp = "localhost";
    int port = 12345;
    IMongodConfig mongodConfig = new MongodConfigBuilder()
            .version(Version.Main.PRODUCTION)
            .net(new Net(bindIp, port, Network.localhostIsIPv6()))
            .build();
    mongodExecutable = null;
    try {
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
    } catch (Exception e){
        // log exception here
        if (mongodExecutable != null)
            mongodExecutable.stop();
    }
}

@AfterClass
public static void teardown() throws Exception {
    if (mongodExecutable != null)
        mongodExecutable.stop();
}