public class MyTest {
   static TemporaryFolder _tempFolder2;

    @Rule
    public TemporaryFolder _tempFolder = new TemporaryFolder();

    @After
    public void after() {
        _tempFolder2 = _tempFolder;
        System.out.println(_tempFolder2.getRoot().exists());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println(_tempFolder2.getRoot().exists());
    }

    @Test
    public void pass() {
    }
}