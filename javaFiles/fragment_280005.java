@RunWith(MockitoJunitRunner.class)
public class ActionRequestHandlerTest {

    @Mock
    private Vertx vertx;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private RequestSerializationWrapper requestWrapper;

    @Mock
    private ProducerTemplate producer;

    @InjectMocks
    private ActionRequestHandler actionRequestHandler;

    @Test
    public void testRegisterConsumer() {
      .... Your code to test ActionRequestHandler#registerConsumer will go here....
    }
}