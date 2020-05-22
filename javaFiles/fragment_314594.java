@Configuration
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private ResourceServerTokenServices tokenServices;

  @Override
  public void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .addFilterBefore(new ApiTokenAccessFilter(tokenServices), AbstractPreAuthenticatedProcessingFilter.class);
  }
}