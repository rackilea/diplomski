@Configuration
@EnableJpaStores
@Import("org.springframework.content.rest.config.RestConfiguration.class")
public class ContentConfig {

   @Value("/org/springframework/content/jpa/schema-drop-h2.sql")
   private Resource dropReopsitoryTables;

   @Value("/org/springframework/content/jpa/schema-h2.sql")
   private Resource dataReopsitorySchema;

   @Bean
   DataSourceInitializer datasourceInitializer() {
     ResourceDatabasePopulator databasePopulator =
            new ResourceDatabasePopulator();

     databasePopulator.addScript(dropReopsitoryTables);
     databasePopulator.addScript(dataReopsitorySchema);
     databasePopulator.setIgnoreFailedDrops(true);

     DataSourceInitializer initializer = new DataSourceInitializer();
     initializer.setDataSource(dataSource());
     initializer.setDatabasePopulator(databasePopulator);

     return initializer;
   }
}