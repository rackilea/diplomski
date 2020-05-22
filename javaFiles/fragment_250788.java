import com.google.api.server.spi.auth.common.User;

@Api(authenticators = MyAuthenticator.class)
public class UserEndpoint {
@ApiMethod(httpMethod = "GET")
public final Response sth(User user)
        throws UnauthorizedException {
    EndpointUtil.throwIfNotAuthenticated(user);

    ((AuthUser)user).getNewToken();

    // ...
}