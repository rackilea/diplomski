@Configuration
@EnableWebMvcSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

public MySecurityConfiguration() {
    super(false);
}

@Override
protected AuthenticationManager authenticationManager() throws Exception {
    return new ProviderManager(Arrays.asList((AuthenticationProvider) new AuthProvider()));
}

}