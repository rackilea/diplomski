@Service
public class ServiceIWantToTestImpl implements ServiceIWantToTest {

    @Autowired
    ComplicatedDependency complicatedDependency;

    public ServiceIWantToTestImpl() {

    }

    public ServiceIWantToTestImpl(ComplicatedDependency complicatedDependency) {
        this.complicatedDependency = complicatedDependency;
    }

    @Override
    public void methodUsingDependency(){
        String string = complicatedDependency.doSomething();
        System.out.println(string);
    }
}

public class TestingTheService {

    private static ServiceIWantToTestImpl serviceIWantToTest;

    @BeforeClass
    public static void init(){
        serviceIWantToTest = new ServiceIWantToTestImpl(new MockComplicatedDependency());
    }

    @Test
    public void testAttempt() {
        serviceIWantToTest.methodUsingDependency();
    }

}