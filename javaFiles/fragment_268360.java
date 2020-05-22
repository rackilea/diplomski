@RunWith(SpringJunitClassRunner.class)
@ContextConfiguration(classes = MvcConfig.class)
public class ViewControllerIT{

   @Autowired
   private WebApplicationContext wac;

   @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLogin() throws Exception {
        this.mockMvc.perform(get("/login")
        .andExpect(status().isOk())
        .andExpect(view().name("login"));
    }
}