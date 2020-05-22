@Configuration
public class ServerEndpointsConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    JsonToUrlEncodedAuthenticationFilter jsonFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(jsonFilter, ChannelProcessingFilter.class)
            .csrf().and().httpBasic().disable()
            .authorizeRequests()
            .antMatchers("/test").permitAll()
            .antMatchers("/secured").authenticated();
    }
}