@Configuration
@PropertySource("classpath:properties.file")
public class DatabaseServiceImplTestConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSourceFactory embeddedDataSourceFactory() {
        return new DataSourceFactory() {
            @Override
            public ConnectionProperties getConnectionProperties() {
                return new ConnectionProperties() {

                    @Override
                    public void setUsername(String username) {}

                    @Override
                    public void setPassword(String password) {}

                    @Override
                    public void setUrl(String url) {}

                    @Override
                    public void setDriverClass(Class<? extends Driver> driverClass) {}

                };
            }

            @Override
            public DataSource getDataSource() {
                SimpleDriverDataSource sds = new SimpleDriverDataSource();
                sds.setDriverClass(com.mysql.jdbc.Driver.class); // <- try to return Driver object too (using setDriver)
                sds.setUrl(env.getProperty("jdbc.connection.url"));
                sds.setUsername(env.getProperty("jdbc.connection.username"));
                sds.setPassword(env.getProperty("jdbc.connection.password"));
                return sds;
            }
        };
    }

    @Bean
    public DataSource embeddedDataSource(DataSourceFactory embeddedDataSourceFactory) {

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("table_name_here")
                .setScriptEncoding("UTF-8")
                .addScript("classpath:path/to/your/shema.sql")
                .setDataSourceFactory(embeddedDataSourceFactory)  // <- call the bean here
                .build();
    }