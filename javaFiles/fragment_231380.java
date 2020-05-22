@RunWith(PowerMockRunner.class)
@PrepareForTest(MySQLDAOFactory.class)
public class MySQLDAOFactoryTest {

    private StationDAO stationDAO;

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    @Before
    public void setUp() {
        stationDAO = new MySQLStationDAO();
    }

    @Test
    public void testGetAllStations_StatementCreated() throws DAOException, SQLException {
        // given
        PowerMockito.mockStatic(MySQLDAOFactory.class);
        Mockito.when(MySQLDAOFactory.getConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);

        // when
        stationDAO.getAllStations();

        // then
        Mockito.verify(mockConnection).createStatement();
    }
}