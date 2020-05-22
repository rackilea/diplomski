@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{

    @Override 
    public void configure(HttpSecurity http) throws Exception {
         // @formatter:off
         http
         .requestMatchers().antMatchers("/bookmarks", "/bookmarks/**")    
         .and()
         .authorizeRequests().anyRequest().access("#oauth2.hasScope('write')");
         // @formatter:on
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(OAuth2Configuration.RESOURCE_ID);
    }

}