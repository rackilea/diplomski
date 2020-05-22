@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerTest {

    private MockMvc mvc;

    @Autowired
    TodoController subject;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testNoErrorSanityCheck() throws Exception {
        String json = "{\"text\":\"a new todo\"}";

        mvc.perform(post("/todo").content(json)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(3))
        .andExpect(jsonPath("$.text").value("a new todo"))
        .andExpect(jsonPath("$.completed").value(false));

        assertThat(subject.getTodos()).hasSize(4);
    }
}