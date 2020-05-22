@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{   
    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.exceptionHandling().authenticationEntryPoint(new AuthExceptionEntryPoint()) ;

    }
}