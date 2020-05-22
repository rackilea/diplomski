@Configuration
public DefaultConfig {

     @Bean
     public DataSource dataSource() { ... }
}

@Configuration
@Profile("jndi")
public class JndiConfig {

    @Bean
    @Primary
    public DataSource jndiDataSource() { ... // JNDI lookup }
}