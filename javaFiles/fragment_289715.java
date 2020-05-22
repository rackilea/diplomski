@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@TestExecutionListeners(listeners = {TransactionalTestExecutionListener.class, ServletTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,})
@Transactional
public class TestIntegrationMyService extends TestMyService {

    @Inject
    @Qualifier("serviceClientId")
    public void setClient(MyService client) {
        this.client = client;
    }

    @Test
    public void validRequestShouldWork() throws Exception {
        client.doSomething();
    }
}