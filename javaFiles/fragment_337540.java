@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class ControllerTest {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    PostService postService;

    @Test
    public void TestHomePage2() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"))
                .andExpect(model().attribute("Post",postService));
    }
}