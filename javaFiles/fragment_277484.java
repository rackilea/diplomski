@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonValidator personValidator;

    @MockBean
    PersonService personService;

    @Test
    public void personAddTest() throws Exception {
        String content = "{\"name\": \"Jimmy\"}";
        mockMvc.perform(post("/Person/Add").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isOk());
    }

    @Test
    public void personAddInvalidTest() throws Exception {
        String content = "{\"noname\": \"Jimmy\"}";
        mockMvc.perform(post("/Person/Add").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isBadRequest());
    }
}