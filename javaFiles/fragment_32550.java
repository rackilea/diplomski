@Configuration
public class TestConfig {
@Bean
public FlywayMigrationStrategy clean() {
    return flyway -> {
        flyway.clean();
        flyway.migrate();
    };
}
}