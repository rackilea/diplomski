@Configuration
@EnableConfigurationProperties(value = DbProperties.class)
public class DatasourceConfig {

    @Bean
    public DataSource dataSource(final DbProperties properties) {
        // do whatever you need
        return DataSourceBuilder.create.url(str.toString()).build();
    }
}