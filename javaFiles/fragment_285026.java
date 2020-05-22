@RunWith(PowerMockRunner.class)
public class ConnectionFactoryTest {

    @Test
    @PrepareForTest(ConnectionFactory.class)
    public void testConnection() throws IOException {
        Connection mockconnection = PowerMockito.mock(Connection.class);
        PowerMockito.mockStatic(ConnectionFactory.class);
        PowerMockito.when(ConnectionFactory.createConnection()).thenReturn(mockconnection);

        // Do something here
    }
}