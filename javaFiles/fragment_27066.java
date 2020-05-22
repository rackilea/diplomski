@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@WithMockUser(roles={"ADMIN"})
public class UserControllerTest {
    @Autowired
    private MockMvcHtmlUnitDriverBuilder builder;

    @MockBean
    private CrowdManagerSyncService service;

    private WebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        webDriver = builder.build();
    }

    @Test
    public void shouldWork() {
        when(service.doStuff())
            .thenReturn("Hello"); // regular Mockito mocking
    }
}