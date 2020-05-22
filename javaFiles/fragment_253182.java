public class TestBlobstore {
  private static final LocalServiceTestHelper helper = 
    new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig(),
                               new LocalBlobstoreServiceTestConfig()
                              );

  public TestBlobstore() {
  }

  @Before
  public void setUp() {
    helper.setUp();
  }

  @Test
  public void testBlobstore() throws Exception {
    System.out.println(createBlob("test.txt"));
  }

  private BlobKey createBlob(String path) throws Exception {
    FileService fileService = FileServiceFactory.getFileService();
    AppEngineFile file = fileService.createNewBlobFile("foobar");
    FileWriteChannel writeChannel = fileService.openWriteChannel(file, true);
    OutputStream output = Channels.newOutputStream(writeChannel);

    // copy files, guava-style
    InputStream input = new FileInputStream(path);
    assertNotNull(input);
    ByteStreams.copy(input, output); 
    input.close();

    // just in case...
    output.flush();
    output.close();
    writeChannel.closeFinally();

    // U NO WORK!!!
    BlobKey blobKey = fileService.getBlobKey(file);
    assertNotNull(blobKey);
    return blobKey;
  }
}