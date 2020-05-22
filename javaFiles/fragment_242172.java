@Configuration
public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter
{
    @Bean(name = Global.AUTHENTICATION_DATA_QUALIFIER + "DataSource")
    public DataSource dataSource()
    {
        return new EmbeddedDatabaseBuilder().setName("authdb").setType(EmbeddedDatabaseType.H2).addScripts("security/schema.sql", "security/data.sql").build();
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception
    {
            auth.jdbcAuthentication().dataSource(dataSource()).passwordEncoder(passwordEncoder());
    }
}