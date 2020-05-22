@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.sessionManagement().enableSessionUrlRewriting(false);

        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .logout()
                    .permitAll()
            .and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/report/**").hasRole("REPORT")
                    .anyRequest().fullyAuthenticated()
            .and().exceptionHandling().accessDeniedPage("/error/403");

    }

    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
            .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER").and()
                .withUser("admin").password("admin").roles("ADMIN","REPORT");
    }

}