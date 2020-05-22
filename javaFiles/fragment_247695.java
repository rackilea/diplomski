@EnableWebSecurity
@EnableGlobalMethodSecurity
@ComponentScan(basePackages = { "com.sample.rest.security" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

     @Override
     public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/signup");
     }
 //////////// OR use below method ///////////
/*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        authorizeRequests().antMatchers("/signup/**").permitAll();
    }
*/
}