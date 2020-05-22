public class IndexTest {

    private Index index = new Index();

    @Test
    public void testIndex() throws IOException {
        MockHttpServletResponse response = new MockHttpServletResponse();
        index.index(response);
        // Some assertions on the response. 
    }
}