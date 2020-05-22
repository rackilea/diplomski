@WebAppConfiguration
    @RunWith(SpringRunner.class)
    @SpringBootTest()
    @ActiveProfiles({"test","wiremock"})
    public class ServiceClientIntegrationTest {

        @Autowired //this is the FeignClient service interface
        public ServiceClient serviceClient;

        @ClassRule
        public static WireMockRule WIREMOCK = new WireMockRule(
                wireMockConfig().fileSource(new ClasspathFileSource("path/to/wiremock/snipptes")).dynamicPort());

        @Test
        public void createSome() {
            ServiceClient.Some t = serviceClient.someOperation(new Some("some"));
            assertTrue(t.getId() > 0);
        }

//using dynamic ports requires to configure the ribbon server list accordingly
        @Profile("wiremock")
        @Configuration
        public static class TestConfiguration {

            @Bean
            public ServerList<Server> ribbonServerList() {
                return new StaticServerList<>(new Server("localhost", WIREMOCK.port()));
            }
        }
    }