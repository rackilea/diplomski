@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String API_KEY_HEADER = "x-api-key";

    private String apiKey = "SomeKey1234567890";

    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        APIKeyFilter filter = new APIKeyFilter(API_KEY_HEADER);
        filter.setAuthenticationManager(authentication -> {
            if(authentication.getPrincipal() == null) // required if you configure http
            {
                throw new BadCredentialsException("Access Denied.");
            }
            String apiKey = (String) authentication.getPrincipal();
            if (authentication.getPrincipal() != null && this.apiKey.equals(apiKey)) 
            {
                authentication.setAuthenticated(true);
                return authentication;
            }
            else
            {
                throw new BadCredentialsException("Access Denied.");
            }
        });

        http.antMatcher("/v1/**")
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .addFilter(filter)
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
}