// unit test
public OrderServiceTest {

    // instance of class-under-test
    private OrderService instance;
    // stub value
    private Date supplierDeliveryDate = new Date();

    // mock as an anonymous inner class
    private Supplier supplier = new Supplier() {
        public Date calculateDeliveryDate(Date input) {
            if (input == null) {
                return null;
            }
            else {
                return supplierDeliveryDate;
            } 
        }
    };

    @Before
    public void setUp() {
        instance = new OrderService();

        // dependency injection
        instance.setSupplier(supplier);
    }

    @Test
    public void testOrderHappy() {
        // SETUP
        Date orderDate = new Date();            

        // CALL
        Date result = instance.order(orderDate);

        // VERIFY
        assertTrue(supplierDeliveryDate == result);
    }

    @Test
    public void testOrderNull() {
        // SETUP
        Date orderDate = null;

        // CALL
        Date result = instance.order(orderDate);

        // VERIFY
        assertNull(result);
    }
}