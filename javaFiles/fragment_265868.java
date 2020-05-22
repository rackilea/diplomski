@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder adminPasswordEncoder;

    @Autowired
    private UserDetailsService adminDetailsService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        UserDetails adminDetails = adminDetailsService.loadUserByUsername(username);
        //adminDetailsService.loadUserByUsername(username) returns Admin inside UserDetails

        if (adminPasswordEncoder.matches(password, adminDetails.getPassword()))
            return new UsernamePasswordAuthenticationToken(adminDetails, password, adminDetails.getAuthorities());
        else
            throw new BadCredentialsException("Bad credentials");
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(CustomAuthenticationToken.class);
    }
}