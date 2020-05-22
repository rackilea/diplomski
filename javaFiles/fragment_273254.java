public class SecurityConfigHTML extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers().antMatchers("/index.html")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login().loginPage("/oauth2/authorization/gitlab");
    }
}