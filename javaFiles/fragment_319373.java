@Configuration
public class IdentifyAnonymousConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Autowired
    private IdentifiableAnonymousAuthenticationFilter identifiableAnonymousAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().authenticationFilter(identifiableAnonymousAuthenticationFilter);
    // ... some other configurations
    }
}