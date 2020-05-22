public class SecurityConfig extends WebSecurityConfigurerAdapter {  

    ... // Other methods here

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .otherConfigOptions
            .logout()
                .addLogoutHandler(customLogoutHandler())  <- custom handler
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .otherConfigOptions....
    }
}