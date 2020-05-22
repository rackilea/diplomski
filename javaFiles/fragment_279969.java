@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/Project/applicationContext servlet.xml")
public class AvamarControllerTest {

    private final static Logger LOGGER = LoggerFactory
                    .getLogger(AvamarControllerTest.class);

    // REMOVED MOCK HERE
    private AvamarController avamar;

    @Mock
    private AvamarAllComponentsVO avamarComponent;

    /*@Before
    public void setupMock() {
        avamar = mock(AvamarController.class);
        avamarComponent = mock(AvamarAllComponentsVO.class);
    }*/

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);

        // INJECT MOCKED DEPENDENCES IF ANY
        avamar = new AvamarController(...inject mocked dependencies if any....);

       // DEPENDING ON WHAT YOU WANNA TEST, MOCK RETURN VALUES...One example below
       Mockito.when(avamarComponent. getApp_Hype_Feat_Filters(any()))
       .thenReturn(null);
    }

    @Test
    public void testGetCompGuidePage()  {
        String productVersion ="7.5";

        // THIS WILL THROW NULL EXCEPTION. NOT SURE IF ITS INTENTSIONAL
        Model model = null;
        ModelAndView modelView = new ModelAndView();
        try {
            modelView = avamar.getCompGuidePage(productVersion , avamarComponent, model );
        } catch (CustomCompGuideException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String abc = "new";
    }
}