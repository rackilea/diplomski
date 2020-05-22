@Configuration
public class OAuth2Config extends AuthorizationServerSecurityConfiguration {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
       http.addFilterAfter(myFilter(), BasicAuthenticationFilter.class);
    }
}