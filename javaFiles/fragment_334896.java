@TestConfiguration
@Order(1)
public class SecurityConfiguration
  implements WebSecurityConfigurer<WebSecurity> {

  @Override
  public void init(WebSecurity builder) throws Exception {
    builder.ignoring().requestMatchers(
      new AntPathRequestMatcher("/**"));
  }

  @Override
  public void configure(WebSecurity builder) throws Exception {
  }

}