@Autowired
private DataSource dataSource;
private DatabaseDataSourceConnection dbUnitConnection;

@BeforeEach
void beforeEach() throws SQLException {
    dbUnitConnection = new DatabaseDataSourceConnection(dataSource, schema);
}