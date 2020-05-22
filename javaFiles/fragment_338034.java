public class DirContextSourceAnonAuthTest {

  private static DirectoryService directoryService;
  private static LdapServer ldapServer;

  @BeforeClass
  public static void startApacheDs() throws Exception {
    String buildDirectory = System.getProperty("buildDirectory");
    File workingDirectory = new File(buildDirectory, "apacheds-work");
    workingDirectory.mkdir();

    directoryService = new DefaultDirectoryService();
    directoryService.setWorkingDirectory(workingDirectory);

    SchemaPartition schemaPartition = directoryService.getSchemaService()
        .getSchemaPartition();

    LdifPartition ldifPartition = new LdifPartition();
    String workingDirectoryPath = directoryService.getWorkingDirectory()
        .getPath();
    ldifPartition.setWorkingDirectory(workingDirectoryPath + "/schema");

    File schemaRepository = new File(workingDirectory, "schema");
    SchemaLdifExtractor extractor = new DefaultSchemaLdifExtractor(
        workingDirectory);
    extractor.extractOrCopy(true);

    schemaPartition.setWrappedPartition(ldifPartition);

    SchemaLoader loader = new LdifSchemaLoader(schemaRepository);
    SchemaManager schemaManager = new DefaultSchemaManager(loader);
    directoryService.setSchemaManager(schemaManager);

    schemaManager.loadAllEnabled();

    schemaPartition.setSchemaManager(schemaManager);

    List<Throwable> errors = schemaManager.getErrors();

    if (!errors.isEmpty())
      throw new Exception("Schema load failed : " + errors);

    JdbmPartition systemPartition = new JdbmPartition();
    systemPartition.setId("system");
    systemPartition.setPartitionDir(new File(directoryService
        .getWorkingDirectory(), "system"));
    systemPartition.setSuffix(ServerDNConstants.SYSTEM_DN);
    systemPartition.setSchemaManager(schemaManager);
    directoryService.setSystemPartition(systemPartition);

    directoryService.setShutdownHookEnabled(false);
    directoryService.getChangeLog().setEnabled(false);

    ldapServer = new LdapServer();
    ldapServer.setTransports(new TcpTransport(11389));
    ldapServer.setDirectoryService(directoryService);

    directoryService.startup();
    ldapServer.start();
  }

  @AfterClass
  public static void stopApacheDs() throws Exception {
    ldapServer.stop();
    directoryService.shutdown();
    directoryService.getWorkingDirectory().delete();
  }

  @Test
  public void anonAuth() throws NamingException {
    DirContextSource.Builder builder = new DirContextSource.Builder(
        "ldap://localhost:11389");
    DirContextSource contextSource = builder.build();

    DirContext context = contextSource.getDirContext();
    assertNotNull(context.getNameInNamespace());
    context.close();
  }

}