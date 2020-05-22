import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${flyway.table}")
    private String flywayTableName;

    @Value("${flyway.baselineVersionAsString}")
    private String baselineVersion;

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            if (!isFlywayInitialized()) {
                flyway.setBaselineVersionAsString(baselineVersion);
                flyway.baseline();
            }
            flyway.migrate();
        };
    }

    private boolean isFlywayInitialized() {

        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet result = metadata.getTables(null, null, flywayTableName, null);
            return result.next();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to check if Flyway is initialized", e);
        }
    }

}