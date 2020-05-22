@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    private iHelper helper;

    @InjectMocks
    @Autowired
    private Service service;

    @Test
    public void testStuff() {
        doNothing().when(helper).helpMeOut();
        service.doSomething();
    }
}