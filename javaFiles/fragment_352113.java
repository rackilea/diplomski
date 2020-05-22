@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Ignore other configuration stuff for simplicity 
        http.authorizeRequests()
                .antMatchers("/sign-up" ,"/verify/**" ).permitAll()
                .anyRequest().authenticated()
    }

}