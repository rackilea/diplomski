public class MyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void myFileTest() throws IOException {
        File testFile = folder.newFile("myfile.txt");
        doStuff(testFile);
    }
}