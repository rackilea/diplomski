public class NextShipmentDaoImpl implements NextShipmentDao{

    private DataSource dataSource;

    JdbcTemplate jdbcTemplate;

    public NextShipmentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }