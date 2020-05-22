@ContextConfiguration("logicContext.xml")
public class BaseLogicTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MyLogic myLogic;

    @Before
    public void injectTestDoubles() {
        myLogic.setMyDao(...);
    }

    @DirtiesContext
    @Test ...//test methods
}