@Configuration
@EnableWebSecurity
public class CASWebSecurityConfig extends WebSecurityConfigurerAdapter {

@Override
protected void configure(HttpSecurity http) throws Exception {
    //disable HTTP Session management
    http
        .securityContext()
        .securityContextRepository(new NullSecurityContextRepository())
        .and()
        .sessionManagement().disable();

    http.requestCache().requestCache(new NullRequestCache());

    //no security checks for health checks
    http.authorizeRequests().antMatchers("/health/**").permitAll();

    http.csrf().disable();

    http
        .exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint());

    http // login configuration
        .addFilter(authenticationFilter())
        .authorizeRequests().anyRequest().authenticated();
}
}