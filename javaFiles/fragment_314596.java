@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.setWebEnvironment(false);
        app.run(args);
    }

    @Bean
    @ConfigurationProperties("my.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}