@RestController
@RequestMapping("/databaseServices")
public class DatabaseTableService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseTableService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTeplate;
    }

    @RequestMapping("/testConnection")
    @ResponseBody
    public boolean canConnectToDB() {
        boolean result;
        try {
            jdbcTemplate.getDataSource().getConnection();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}