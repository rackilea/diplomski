@Component
public interface JwtAuthenticationProviderService implements AuthenticationProvider {

public Authentication authenticate(Authentication authentication)

public boolean supports(Class<?> authentication)
}