public class IntegrationTest {

    MockMvc mockMvc;
    MyService service;
    Controller controller;

    @Mock
    Client client;

    @Autowired
    Factory factory;

    @Before
    public void setup() {
        initMocks(this);
        MyService service = new MyService(client, factory);
        controller = new Controller(service);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }