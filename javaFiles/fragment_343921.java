@RunWith(SpringRunner.class)
@WebMvcTest(Index.class)
public class IndexTest {

    @Autowired
    private Index index;

    @Test
    public void testIndex() throws IOException {
        MockHttpServletResponse response = new MockHttpServletResponse();
        index.index(response);
        // Some assertions on the response. 
    }
}