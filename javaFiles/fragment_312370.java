@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ATest.CONTEXT_CONFIGURATION)
public class REjercicioDAOTest extends ATest {

    @Mock 
    private ICustomFileHandler customFileHandler;

    @Autowired        
    private IREjercicioDAO rEjercicioDAO;

    @Before
    public void before () {    
        MockitoAnnotations.initMocks(this);
        // Set explicitly the fileHandler dependency
        rEjercicioDAO.setFileHandler(customFileHandler);         
    }
 }