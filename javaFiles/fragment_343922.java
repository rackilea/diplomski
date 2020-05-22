@RunWith(SpringRunner.class)
@WebMvcTest(Index.class)
public class IndexTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndex() throws IOException {
        mockMvc.perform(get("/")).
            andExpect(status().isMovedTemporarily());
        MockHttpServletResponse response = new MockHttpServletResponse();
        index.index(response);
        // Some assertions on the response. 
    }
}