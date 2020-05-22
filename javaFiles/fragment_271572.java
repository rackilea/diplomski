@EnableWebSecurity
public class MyConfiguration {

    @Autowired
    public void whatever(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user").password("password").roles("USER").and()
          .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    ...

}