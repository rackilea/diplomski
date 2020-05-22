public class DemoApplicationTests {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new HelloWorld()).build();
    }

    @Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(get("/")
           .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
           .andExpect(status().isOk())
           .andExpect(content().contentType("application/json"));

    }
}