@Configuration
@Order(1)
public static class ApiLoginWebSecurityConfigurationAdapter extends
        WebSecurityConfigurerAdapter {

    @Autowired
    private Http403ForbiddenEntryPoint forbiddenEntryPoint;

    @Bean
    public Http403ForbiddenEntryPoint forbiddenEntryPoint() {
        return new Http403ForbiddenEntryPoint();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
            .and()
                .httpBasic()
                .authenticationEntryPoint(forbiddenEntryPoint)
            .and()
                .csrf().disable();
        // @formatter:on
    }
}