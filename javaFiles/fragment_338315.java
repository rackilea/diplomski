@RestClientTest(FooService.class)
public class FooServiceTest {

    @Autowired
    private FooService service;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void testIndex() throws Exception {
        this.server.expect(requestTo("http://localhost:8080")).andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));
        String greeting = this.service.getIndex();
        assertEquals(greeting, "hello");
    }
}