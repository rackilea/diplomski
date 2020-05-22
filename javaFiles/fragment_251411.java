@Configuration
@EnableResourceServer
public class App extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
    http.requestMatchers().antMatchers("/api/**").and().authorizeRequests()
                .antMatchers("/api/**").authenticated();
}
  //Do others stuff
}