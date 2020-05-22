@Service(value = "customAuth")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public Storages storage;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String login = authentication.getName();
    String password = authentication.getCredentials().toString();
    User user = storage.uSM.findByEmailAndPassword(login, password);
    if (user == null) {
        return null;
    } else {
        // Here use the user object to only check if the user exists in the database if not null use his login ( principal ) and password
        return new UsernamePasswordAuthenticationToken(login, password);
    }
    }

    @Override
    public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}