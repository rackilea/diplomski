@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-test.xml")

public class ServiceHandlerTest {

    @Before
    public void setup() {
        //Create ServiceObject and save to DB
    }


    @Test
    public void testServiceMethod() {
        //Call serviceMethod()
        //Read DB for updatedServiceObject

        assertEquals("Test: Object should be in updated state", new Short(3), updatedServiceObject.getObjectstatus(), 0);
    }

    @After
    public void teardown() {
        //Delete created ServiceObject from DB
    }
}