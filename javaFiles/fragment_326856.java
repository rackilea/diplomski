@RunWith(MockitoJUnitRunner.class)
public class SomeClassTest {

    @Mock
    private ResultSet resultSet;

    @Test
    public void testConvert() throws SQLException {
        // Define the behavior of the mock for each getString method's call
        Mockito.when(resultSet.getString("id")).thenReturn("myId");
        Mockito.when(resultSet.getString("sysname")).thenReturn("myHost");
        Mockito.when(resultSet.getString("zos")).thenReturn("myOS");
        Mockito.when(resultSet.getString("customer_name")).thenReturn("myCustomerName");

        // Launch the method against your mock
        SomeClass someClass = new SomeClass();
        CItem item = someClass.convert(resultSet);

        // Check the result
        Assert.assertNotNull(item);
        Assert.assertEquals("myId", item.getHinumber());
        Assert.assertEquals("myHost", item.getHostname());
        Assert.assertEquals("myOS", item.getOs());
        Assert.assertEquals("myCustomerName", item.getTenant());
    }
}