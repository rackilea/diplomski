@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

// constructor

  @Override
  protected void configure(HttpSecurity http) throws Exception {
  // custom configuration of your http

  //register the filter
  http.addFilterAfter(new ResponseFilter(), ResponseFilter.class);
  }
}