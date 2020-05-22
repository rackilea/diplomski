@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        //credentials and roles to use
        auth.inMemoryAuthentication().withUser("soapuser").password("secret").roles("ADMIN");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception{

        //this configuration define that every request is authorized only to Admin roles and authenticated users.
        http
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()

                //this configuration define an http basic authentication
                .and().httpBasic()

                //disable csfr
                .and().csrf().disable();
    }

}