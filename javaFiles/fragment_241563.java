private MockMvc mockMvc;

 private SomeController controller = new SomeController();
 @Mock 
 private ResourceAdminService resourceAdminService;


 @Before
 public void setup() throws Exception {
    controller.setResourceAdminService(resourceAdminService);
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
 }