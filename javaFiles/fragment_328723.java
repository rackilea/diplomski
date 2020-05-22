@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes ={ServerConfig.class,ServerThroughAMQPBrokerRabbitMQIntegrationTestConfig.class})
@Category({IntegrationTest.class})
@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@TestExecutionListeners(listeners = {DirtiesContextBeforeModesTestExecutionListener.class, DirtiesContextTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class ServerThroughAMQPBrokerRabbitMQIntegrationTest {