@RunWith(MockitoJunitRunner.class)
public class AuditServiceTest {
    @Mock 
    private BackOfficeProperties backOfficeProperties;
    @Mock 
    private AuditFactory auditFactory;
    @Mock 
    private AuditDao auditDao;
    @Mock 
    private RedisDao redisDao;
    @Mock 
    private ObjectMapper objectMapper;
    @Mock 
    private I18nResourceBundleMessageSource i18nResourceBundleMessageSource;
    @InjectMocks
    private AuditService auditService;

    @Before
    public void setup(){
       Mockito
           .when(backOfficeProperties.getUrlFrontOffice())
           .thenReturn("http://some.valid.url");
    }

    // your tests
}