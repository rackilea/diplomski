@RunWith(PowerMockRunner.class)
@PrepareForTest(IConcurrentUtil.class)
@PowerMockIgnore("javax.management.*")
public class ConcurrentUtilTest {

    private ConcurrentUser concurrentUser;

    @Before
    public void setUp() {
        concurrentUser = new ConcurrentUser();
    }

    @Test
    public void testThreadSleepCallsSleepCorrect() throws Exception {
        PowerMockito.mockStatic(IConcurrentUtil.class);

        concurrentUser.callInterfaceMethod();

        PowerMockito.verifyStatic(Mockito.times(1));
        IConcurrentUtil.threadSleep(3000L);
    }
}