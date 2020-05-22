@Component
public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager,
                                     AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }
}