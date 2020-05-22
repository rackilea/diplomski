@Configuration
public class DatasourceConfig {
    @Value("${spring.datasource.jiano.jndi-name}")
    private String primaryJndiName;

    @Value("${spring.datasource.sgu.jndi-name}")
    private String secondaryJndiName;

    private JndiDataSourceLookup lookup = new JndiDataSourceLookup();

    @Primary
    @Bean(destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource primaryDs() {
        return lookup.getDataSource(primaryJndiName);
    }

    @Bean(name = "sguDs", destroyMethod = "") // destroy method is disabled for Weblogic update app ability
    public DataSource secondaryDs() {
        return lookup.getDataSource(secondaryJndiName);
    }    

    @Bean
    public JdbcTemplate jdbcTemplate(){
      return new JdbcTemplate(secondaryDs());
    }
}