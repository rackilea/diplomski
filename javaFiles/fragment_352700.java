public class DummyFileClassTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void someMethod() {
        // given
        final File file1 = folder.newFile("myfile1.txt");
        final File file2 = folder.newFile("myfile2.txt");

        ... etc...
    }
}