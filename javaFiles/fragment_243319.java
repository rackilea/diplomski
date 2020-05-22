@Repository
public class CustomerJDBCTemplate implements CustomerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Rest of your methods
}