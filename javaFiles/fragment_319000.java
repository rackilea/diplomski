@Configuration
@EnableWebSecurity
@ComponentScan("...")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
  @Override
  public void configure(HttpSecurity http) throws Exception
  {
    http.addFilterBefore(corsFilter(), ChannelProcessingFilter.class).logout().deleteCookies("JESSIONID")
        .logoutUrl("/api/logout").logoutSuccessHandler(logoutSuccessHandler()).and().formLogin().loginPage("/login")
        .loginProcessingUrl("/api/login").failureHandler(authenticationFailureHandler())
        .successHandler(authenticationSuccessHandler()).and().csrf().disable().exceptionHandling()
        .authenticationEntryPoint(authenticationEntryPoint()).accessDeniedHandler(accessDeniedHandler());
  }

  /**
   * @return Custom {@link AuthenticationFailureHandler} to send suitable response to REST clients in the event of a
   *         failed authentication attempt.
   */
  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler()
  {
    return new RestAuthenticationFailureHandler();
  }

  /**
   * @return Custom {@link AuthenticationSuccessHandler} to send suitable response to REST clients in the event of a
   *         successful authentication attempt.
   */
  @Bean
  public AuthenticationSuccessHandler authenticationSuccessHandler()
  {
    return new RestAuthenticationSuccessHandler();
  }

  /**
   * @return Custom {@link AccessDeniedHandler} to send suitable response to REST clients in the event of an attempt to
   *         access resources to which the user has insufficient privileges.
   */
  @Bean
  public AccessDeniedHandler accessDeniedHandler()
  {
    return new RestAccessDeniedHandler();
  }
}