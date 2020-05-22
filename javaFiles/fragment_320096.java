@Component
public class MyJavaMigration extends BaseJavaMigration {
...
}

@Component
public class MyFlywayMigration implements CommandLineRunner {

    @Autowired
    private MyJavaMigration myJavaMigration;

    @Autowired
    private DataSource dataSource; 

    @Override
    public void run(String... args) {
      JavaMigrations migrations[] = {myJavaMigration};
      Flyway flyway = Flyway.configure()
                            .dataSource(dataSource)
                            .javaMigrations(migrations)
                            .load();
      flyway.migrate();
    }
}