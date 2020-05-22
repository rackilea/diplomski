@Controller // Will be detected by <context:component-scan>
@RequestMapping // Will be detected by <mvc:annotation-driven> (more specifically by one of its component - RequestMappingHandlerMapping)
public class IndexController {

    @Autowired // Spring will inject JdbcTemplate here
    private JdbcOperations jdbcOperations; 

    @RequestMapping // This method should be called for requests to "/" 
    @ResponseBody // Returned string will be returned to client... normally you would register view resolver and just return name of a JSP to render
    public String renderIndex() {
        // You don't need to worry about JDBC's DataSource, Connection, ResultSet, ... just use JdbcTemplate
        long rowCount = jdbcOperations.queryForLong("SELECT COUNT(*) FROM my_test_table;");
        return "Number of rows in database is: " + String.valueOf(rowCount);
    } 

}