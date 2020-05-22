@Configuration
@EnableJpaStores
@Import("org.springframework.content.rest.config.RestConfiguration.class")
public class ContentConfig {

    // schema management
    // 
    @Value("/org/springframework/content/jpa/schema-drop-mysql.sql")
    private Resource dropContentTables;

    @Value("/org/springframework/content/jpa/schema-mysql.sql")
    private Resource createContentTables;

    @Bean
    DataSourceInitializer datasourceInitializer() {
        ResourceDatabasePopulator databasePopulator =
                new ResourceDatabasePopulator();

        databasePopulator.addScript(dropContentTables);
        databasePopulator.addScript(createContentTables);
        databasePopulator.setIgnoreFailedDrops(true);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());
        initializer.setDatabasePopulator(databasePopulator);

        return initializer;
    }
}