import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import xxx.repository.security.UserRepository;
import xxx.model.security.User;
import xxx.service.security.impl.acegi.AcegiUserDetails;

public class ReloadUserPerRequestHttpSessionSecurityContextRepository extends HttpSessionSecurityContextRepository {

    // Your particular data store object would be used here...
    private UserRepository userRepository;

    public ReloadUserPerRequestHttpSessionSecurityContextRepository(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {

        // Let the parent class actually get the SecurityContext from the HTTPSession first.
        SecurityContext context = super.loadContext(requestResponseHolder);

        Authentication authentication = context.getAuthentication();

        // We have two types of logins for our system, username/password
        // and Openid, you will have to specialize this code for your particular application.
        if (authentication instanceof UsernamePasswordAuthenticationToken) {

            UserDetails userDetails = this.createNewUserDetailsFromPrincipal(authentication.getPrincipal());

            // Create a new Authentication object, Authentications are immutable.
            UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(userDetails, authentication.getCredentials(), userDetails.getAuthorities());

            context.setAuthentication(newAuthentication);

        } else if (authentication instanceof OpenIDAuthenticationToken) {

            UserDetails userDetails = this.createNewUserDetailsFromPrincipal(authentication.getPrincipal());

            OpenIDAuthenticationToken openidAuthenticationToken = (OpenIDAuthenticationToken) authentication;

            // Create a new Authentication object, Authentications are immutable.
            OpenIDAuthenticationToken newAuthentication = new OpenIDAuthenticationToken(userDetails, userDetails.getAuthorities(), openidAuthenticationToken.getIdentityUrl(), openidAuthenticationToken.getAttributes());

            context.setAuthentication(newAuthentication);
        }

        return context;
    }

    private UserDetails createNewUserDetailsFromPrincipal(Object principal) {

        // This is the class we use to implement the Spring Security UserDetails interface.
        AcegiUserDetails userDetails = (AcegiUserDetails) principal;

        User user = this.userRepository.getUserFromSecondaryCache(userDetails.getUserIdentifier());

        // NOTE:  We create a new UserDetails by passing in our non-serializable object 'User', but that object in the AcegiUserDetails is transient.
        // We use a UUID (which is serializable) to reload the user.  See the userDetails.getUserIdentifier() method above.
        userDetails = new AcegiUserDetails(user);

        return userDetails;
    }
}