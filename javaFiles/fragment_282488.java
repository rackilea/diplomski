JdbcTemplate jdbcTemplate;

@Autowired
public HelloController(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate=jdbcTemplate;
}