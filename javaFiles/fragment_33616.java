@RunWith(MockitoJUnitRunner.class)
public class AddressRepositoryOfflineTest extends TestCase {

@Mock
private InitialData initialData;

@InjectMocks
private AddressRepositoryOffline aro; 

@Test
public void testPersistAddress() {
    Address newAddress = new Address("a", "a");
    ArrayList<Address> addList = new ArrayList<Address>();
    addList.add(newAddress);

    Mockito.when(initialData.getAddresses()).thenReturn(addList);
    assertEquals(newAddress, aro.getAddresses().get(0));
}
}