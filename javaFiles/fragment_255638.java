@RunWith(PowerMockRunner.class)
@PrepareForTest({ ServiceExecutor.class })
@SuppressStaticInitializationFor("com.gpcoder.staticblock.ServiceExecutor")
public class FirstControllerTest {

    @Before
    public void prepareForTest() throws Exception {
        PowerMockito.mockStatic(ServiceExecutor.class);
        PowerMockito.doNothing().when(ServiceExecutor.class);
    }

    @Test
    public void doSomethingTest() {
        FirstController firstController = new FirstController();
        firstController.doSomething();
        PowerMockito.verifyStatic(ServiceExecutor.class, Mockito.times(1));
    }
}