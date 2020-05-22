@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceTest {
    @InjectMocks
    private DocumentService documentService;
    @Mock
    private DocumentConfig documentConfig;

    @Test
    public void save_failure()  {
        when(this.documentConfig.isNameRequired()).thenReturn(true); 
        // TODO: Implement test
    }
}