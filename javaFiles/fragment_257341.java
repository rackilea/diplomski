@SpringJunit4Runner(....="app.xml")
public class OrderTest {

    @Resource
    private OrderController controller; //bean from app.xml

    @Resource
    private OrderService service; // actual order service
    private OrderService mockOrderService; //some mock order service
    private MockHttpServletRequest request;

    @BeforeMethod
    public void setUp() {
        request = new MockHttpServletRequest();
        request.addParameter("orderNumber", String.valueOf(orderNumber));
    }

    @Test
    public void successSave() {
        //test with orderService the way you would do it
    }

    @Test
    @DirtiesContext
    //need the annotation because we are changing our context beans i.e, ordercontroller
    //so for the next test the context would be recreated
    public void successSaveWithMock() {
        mockOrderService = //create mock service
        orderController.setOrderService(mockOrderService);
        //do the test with mock
    }
}