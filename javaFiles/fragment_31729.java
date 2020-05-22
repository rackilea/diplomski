@EnableWebSecurity
public class WebMVCSecurity {
    //Configure Authentication as normal, optional, showing just as a sample to indicate you can add other config like this
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    // Create an instance of WebSecurityConfigurerAdapter that contains @Order to specify which WebSecurityConfigurerAdapter should be considered first.
    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            // The http.antMatcher states that this HttpSecurity will only be applicable to URLs that match with **/course/embed/**
            http.antMatcher("**/course/embed/**").headers().frameOptions().sameOrigin();
        }
    }

    // Create another instance of WebSecurityConfigurerAdapter. 
    // If the URL does not match with **/course/embed/** this configuration will be used. 
    // This configuration is considered after ApiWebSecurityConfigurationAdapter since it has an @Order value after 1 (no @Order defaults to last).
    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin();

            //bla bla bla ...
        }
    }
}