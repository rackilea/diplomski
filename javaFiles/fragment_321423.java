@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TodoController subject;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void testCreate() throws Exception {
    String json = "{\"text\":\"a new todo\"}";

    mvc.perform(post("/todo").content(json)
                             .contentType(APPLICATION_JSON)
                             .accept(APPLICATION_JSON))
       .andExpect(status().isOk())
       .andExpect(jsonPath("$.id").value(3))
       .andExpect(jsonPath("$.text").value("a new todo"))
       .andExpect(jsonPath("$.completed").value(false));

        Mockito.verify(todoRepository, Mockito.times(1)).save(any(Todo.class));
    }
}