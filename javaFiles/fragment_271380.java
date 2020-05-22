@Component
public class MyBean {
    @Autowired
    private JdbcOperations jdbc;

    public void doJdbcStuff() {
        // use jdbc
    }
}