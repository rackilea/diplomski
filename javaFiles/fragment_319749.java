@RunWith(PowerMockRunner.class)
public class BoxFileDaoTest {

    @Mock
    private BoxFileService boxFileService;

    @InjectMocks
    private BoxFileDao boxFileDao;

    @Test
    public void testUploadFile() {
        boxFileDao.uploadFile();
        verify(boxFileService).uploadFile(user, credential);
    }
}