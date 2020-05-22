@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext_mock.xml" })
public class OwnerIntegrationTest {

    @Autowired
    OwnerService ownerService;

    @Before
    public void setup() {

        ownerService.cleanList();

    }

    @Test
    public void testOwners() {

        Owner owner = new Owner("Bengt", "Karlsson", "Ankavägen 3");
        owner = ownerService.createOwner(owner);
        assertEquals("Check firstName : ", "Bengt", owner.getFirstName());
        assertTrue("Check that Id exist: ", owner.getId() > 0);

        owner.setLastName("Larsson");
        ownerService.updateOwner(owner);
        owner = ownerService.getOwner(owner.getId());
        assertEquals("Name is changed", "Larsson", owner.getLastName());

    }