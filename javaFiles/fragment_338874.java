@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private WebApplicationContext webApplicationContext;

   @Autowired
   private Controller controller;

   @Before
   public void setUp() {
    mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build();
      }

    @Test
    public void getWaitingItems() throws Exception  {
    mockMvc.perform(get("/user/{userId}/todo-list", 1L))
            .andExpect(status().isOk());
         }
    }