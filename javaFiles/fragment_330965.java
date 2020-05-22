@Configuration
public class FlywayFactory {

    @Bean
    public FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
        flyway.setCallbacks(flywayCallback());
        return new FlywayMigrationInitializer(flyway);
    }

    @Bean
    public FlywayCallback flywayCallback() {
        return new LogMaintenanceFlywayCallback();
    }

}