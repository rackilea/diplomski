@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.httpBasic().and().authorizeRequests().
        antMatchers(HttpMethod.POST, "/posts").hasRole("USER").
        antMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN").and().
        csrf().disable();
  }
}