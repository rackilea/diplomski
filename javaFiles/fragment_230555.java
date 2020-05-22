public class MyServletTest {
    //MUST be public
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setTestPaths() throws Exception {
        File cancelFile = tempFolder.newFile("Cancel.txt");
        File cancelTemp = tempFolder.newFile("Cancel_temp.txt");

        System.setProperty("canceled.filepath", cancelFile.getAbsolutePath());
        System.setProperty("temp.filepath", cancelTemp.getAbsolutePath());
    }

    @After
    public void restorePaths() {
        //FIXME:  The JVM will be reused, if you have any other tests relying on the system properites they will be getting the values set in the BEFORE block.
    }

    @Test
    public void checkSysVars() {
        String cancelPath = System.getProperty("canceled.filepath");
        String tmpPath = System.getProperty("temp.filepath");

        File cancelFile = new File(cancelPath);
        File cancelTemp = new File(tmpPath);
        System.out.println(cancelFile.getAbsolutePath());
        System.out.println(cancelFile.exists());
        System.out.println(cancelTemp.getAbsolutePath());
        System.out.println(cancelTemp.exists());

    }
}