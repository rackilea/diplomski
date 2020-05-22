// this test case need to mock static methods so it uses PowerMock
@RunWith(PowerMockRunner.class)
// this static methods to be mocked are on Environment so that must be 'prepared'
@PrepareForTest({Environment.class})
public class StorageUtilsTest {

    @Rule
    public TemporaryFolder storageDirectory = new TemporaryFolder();

    private File nonExistentDirectory;
    private File existentDirectory;

    @Before
    public void setup() {
        nonExistentDirectory = Mockito.mock(File.class);
        Mockito.when(nonExistentDirectory.exists()).thenReturn(false);

        existentDirectory = storageDirectory.getRoot();

        PowerMockito.mockStatic(Environment.class);
    }

    @Test
    public void willUseTheExternalStoragePublicDirectoryWhenItIsAvailable() {
        // external storage is writeable
        Mockito.when(Environment.getExternalStorageState()).thenReturn(Environment.MEDIA_MOUNTED);
        // the external storage public directory is available
        Mockito.when(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)).thenReturn(existentDirectory);

        String fileName = "someFileName";
        String logFilePath = StorageUtils.getLogFilePath(fileName);

        Assert.assertEquals(existentDirectory.getAbsolutePath() + File.separator + fileName, logFilePath);
    }

    @Test
    public void willUseTheExternalStorageDirectoryWhenItIsAvailable() {
        // external storage is writeable
        Mockito.when(Environment.getExternalStorageState()).thenReturn(Environment.MEDIA_MOUNTED);
        // the external storage public directory is not available
        Mockito.when(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)).thenReturn(nonExistentDirectory);
        // the external storage directory is available
        Mockito.when(Environment.getExternalStorageDirectory()).thenReturn(existentDirectory);

        String fileName = "someFileName";
        String logFilePath = StorageUtils.getLogFilePath(fileName);

        Assert.assertEquals(existentDirectory.getAbsolutePath() + File.separator + fileName, logFilePath);
    }

    @Test
    public void willUseTheDataDirectoryWhenExternalStorageIsNotWriteable() {
        // external storage is not writeable
        Mockito.when(Environment.getExternalStorageState()).thenReturn("not media mounted");
        // the data directory is available
        Mockito.when(Environment.getDataDirectory()).thenReturn(existentDirectory);

        String fileName = "someFileName";
        String logFilePath = StorageUtils.getLogFilePath(fileName);

        Assert.assertEquals(existentDirectory.getAbsolutePath() + File.separator + fileName, logFilePath);
    }

    @Test
    public void willUseTheDataDirectoryWhenNothingElseIsAvailable() {
        // external storage is writeable
        Mockito.when(Environment.getExternalStorageState()).thenReturn(Environment.MEDIA_MOUNTED);
        // but neither of the external storage directories are available
        Mockito.when(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)).thenReturn(nonExistentDirectory);
        Mockito.when(Environment.getExternalStorageDirectory()).thenReturn(nonExistentDirectory);
        // so we must fall through to the data directory
        Mockito.when(Environment.getDataDirectory()).thenReturn(existentDirectory);

        String fileName = "someFileName";
        String logFilePath = StorageUtils.getLogFilePath(fileName);

        Assert.assertEquals(existentDirectory.getAbsolutePath() + File.separator + fileName, logFilePath);
    }

    @Test
    public void doesSomethingWhenGivenANullFileName() {
        // external storage is writeable
        Mockito.when(Environment.getExternalStorageState()).thenReturn(Environment.MEDIA_MOUNTED);
        // the external storage public directory is available
        Mockito.when(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)).thenReturn(existentDirectory);

        String logFilePath = StorageUtils.getLogFilePath(null);

        // the assertion here will depend on what your getAbsoluteFilePath() method does with a null file name!
        Assert.assertEquals(existentDirectory.getAbsolutePath() + File.separator, logFilePath);
    }
}