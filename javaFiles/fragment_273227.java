public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                .httpBasic()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)   
                .and().authorizeRequests()
                .antMatchers(
                        "/", "/csrf", 
                        "/v2/api-docs", 
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**"
                        ).permitAll()
                .anyRequest().authenticated();

    }
}