@Configuration
    @PropertySource("classpath:myIntegration.properties")
    public class MyInetgrationApplicationConfig {

        @Autowired
        private Environment environment;

        @Bean
        @Primary
        public DataSource dataSource() {
            DataSource dataSource = new DataSource();
            dataSource.setName(environment.getProperty("datasource.name"));
            dataSource.setUrl(environment.getProperty("datasource.url"));
            .
            .
            .
            .
            return dataSource;
        }
   }