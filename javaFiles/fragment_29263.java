@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/settings").hasAuthority("Administrator").and()
                .exceptionHandling()
                .accessDeniedPage(...)
                .accessDeniedHandler(...)

    }
}