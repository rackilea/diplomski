@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void testCall() throws Exception {
        //increment first time
        this.mvc.perform(get("/greeting"))
                .andExpect(status().isOk());
        //increment secont time and get response to check
        String contentAsString = this.mvc.perform(get("/greeting"))
                .andExpect(status().isOk()).andReturn()
                .getResponse().getContentAsString();
        assertEquals("Hello World 2", contentAsString);
    }
}