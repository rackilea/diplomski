@RunWith(SpringRunner.class)
@SpringBootTest
public class HystrixProxyServiceTests {

    @MockBean
    private MyRepo myRepo;

    @Autowired
    private MyService myService;

    private static final String ID = “1”;

    @Before
    public void setup() {
        resetHystrix();
        openCircuitBreakerAfterOneFailingRequest();
    }

    @Test
    public void circuitBreakerClosedOnSuccess() throws IOException, InterruptedException {

        when(myRepo.findOneById(USER_ID1))
        .thenReturn(Optional.of(Document.builder().build()));

        myService.findOneById(USER_ID1);
        HystrixCircuitBreaker circuitBreaker = getCircuitBreaker();
        Assert.assertTrue(circuitBreaker.allowRequest());

        verify(myRepo, times(1)).findOneById(
            any(String.class));
    }

    @Test
    public void circuitBreakerOpenOnException() throws IOException, InterruptedException {

        when(myRepo.findOneById(ID))
            .thenThrow(new RuntimeException());

        try {
            myService.findOneById(ID);
        } catch (RuntimeException exception) {
            waitUntilCircuitBreakerOpens();
            HystrixCircuitBreaker circuitBreaker = getCircuitBreaker();
            Assert.assertFalse(circuitBreaker.allowRequest());
        }

        verify(myRepo, times(1)).findOneById(
            any(String.class));
    }

    private void waitUntilCircuitBreakerOpens() throws InterruptedException {
        Thread.sleep(1000);
    }

    private void resetHystrix() {
        Hystrix.reset();
    }

    private void warmUpCircuitBreaker() {
        myService.findOneById(USER_ID1);
    }

    public static HystrixCircuitBreaker getCircuitBreaker() {
        return HystrixCircuitBreaker.Factory.getInstance(getCommandKey());
    }

    private static HystrixCommandKey getCommandKey() {
        return HystrixCommandKey.Factory.asKey("findOneById");
    }

    private void openCircuitBreakerAfterOneFailingRequest() {

        ConfigurationManager.getConfigInstance().
            setProperty("hystrix.command.findOneById.circuitBreaker.requestVolumeThreshold", 1);
    }

}