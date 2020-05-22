@Configuration
public class CustomWebSecurityConfigurerAdapter
  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(
          new CustomFilter(), BasicAuthenticationFilter.class);
    }
}