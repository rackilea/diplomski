@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FrontEndControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private FrontEndController frontEndController;

    @Autowired
    private SomeConfigObject config;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(frontEndController).build();
    }

    @Test
    public void shouldDirectToSomeView() throws Exception {
        // mock valid behaviour of config

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("someView"));
    }

    @Test
    public void shouldNotDirectToSomeView_InvalidConfiguration() throws Exception {
        // mock invalid behaviour of config

        mockMvc.perform(get("/"))
                .andExpect(status().is5xxServerError())
    }

    @Configuration
    public static class FrontEndControllerTestConfiguration {

        @Bean
        public FrontEndController defaultController() {
            return // init controller
        }

        @Bean
        public SomeConfigObject config() {
            return mock(SomeConfigObject.class);
        }
    }
}