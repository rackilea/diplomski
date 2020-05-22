@SpringBootApplication
public class Application {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:h2:mem:primary")
                .username("primary")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean
    CommandLineRunner basics(final RuntimeService runtimeService,
                             final WaiterRepository repository) {
        return new CommandLineRunner() {

            @Override
            public void run(String... strings) throws Exception {
                runtimeService.startProcessInstanceByKey(
                        "waiter2",
                        Collections.singletonMap(
                                "customerId",
                                (Object) repository.save(new WaiterEntity(123L)).getCustomerId()));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}