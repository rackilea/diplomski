@Component
public class Startup {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void runNativeSql() {
        ClassPathResource resource = new ClassPathResource("scripts/myscript.sql");
        try(Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, resource);
        } catch (SQLException | ScriptException e) {
            //LOG
        }
    }
}