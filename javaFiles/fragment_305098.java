@Configuration
@EnableWebSecurity
public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/dashboard/home/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/dashboard/users/**").hasRole("ADMIN")
                .antMatchers("/rest/users/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/")
                .permitAll();
    }

    // Possibly more overridden methods ...
}