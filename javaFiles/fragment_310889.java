@Configuration // @Order(99) is important so this bean is initialized before the
@Order(99)     // AuthorizationServerConfigurer at 100           
public class AuthenticationManagerProvider extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}