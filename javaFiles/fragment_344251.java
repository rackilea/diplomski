public class JGitTest {

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder();

  private Git git;

  @Before
  public void setUp() throws GitAPIException {
    git = Git.init().setDirectory( tempFolder.getRoot() ).call();
  }

  @After
  public void tearDown() {
    git.getRepository().close();
  }

  @Test
  public void testFirst() {
    // with 'git' you have access to a fully functional repository
  }
}