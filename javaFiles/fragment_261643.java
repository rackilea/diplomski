@RunWith(JUnit4.class)
public class ExampleTest {
  @Rule
  public TemporaryFolder testFolder = new TemporaryFolder();

  private final Foo foo = new Foo();

  @Test
  public void shouldFailIfFilesDoNotExist() {
    List<File> files = Lists.newArrayList(
        testFolder.newFile(),
        testFolder.newFile(),
        testFolder.newFile());
    foo.doIt(files);
  }
}