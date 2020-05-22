@RunWith(MockitoJUnitRunner.class)
public class TestingTheService {

    @InjectMocks
    private static ServiceIWantToTestImpl serviceIWantToTest = new ServiceIWantToTestImpl();

    @Spy
    private static ComplicatedDependency complicatedDependency = new MockComplicatedDependency();

    @BeforeClass
    public static void init() {

    }

    @Test
    public void testAttempt() {
        serviceIWantToTest.methodUsingDependency();
    }

}