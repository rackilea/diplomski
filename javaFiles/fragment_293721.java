@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@ActiveProfiles("test") // set profile "test"
public class WebSocketDataSourceTest {

    @Autowired 
    private Example example;

    @Autowired
    private WebSocketServer server;

    @Test
    public void shouldWork() {
        // ...
        example.onApplicationEvent(null); // trigger manually
        // ...
    }
}