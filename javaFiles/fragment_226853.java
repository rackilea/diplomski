@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    // Other config
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
       //Other config
       httpSecurity.addFilterBefore(authTokenFilter,
                    UsernamePasswordAuthenticationFilter.class);
    }
}