@Component
public class LoginDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginDao(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getUser(final String username, final String password) {
        return jdbcTemplate.queryForList("select * from users where username=? and password=?", new Object[]{username, password});
    }
}