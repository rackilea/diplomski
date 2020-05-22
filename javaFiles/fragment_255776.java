public class MyConfig {

    @Value("${" + JDBC_DEMO_DS + "}")
    private DataSource demoDs;

}