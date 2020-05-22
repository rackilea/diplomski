import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GetTokenByAuthenticationCode {

    private static final String APP_ID = "***";
    private static final String APP_SECRET = "***";
    private static final String REDIRECT_URI = "http://localhost:8080";
    private static final String tenant = "***";

    public static void main(String[] args) throws Exception {

        String authority = "https://login.microsoftonline.com/" + tenant + "/oauth2/authorize";
        ExecutorService service = Executors.newFixedThreadPool(1);

        String code = "***";

        AuthenticationContext context = new AuthenticationContext(authority, true, service);

        URI url = new URI(REDIRECT_URI);

        Future<AuthenticationResult> result = context.acquireTokenByAuthorizationCode(
                code,
                url,
                new ClientCredential(APP_ID, APP_SECRET),
                null
        );
        String token = result.get().getAccessToken();
        System.out.println(token);
        String refreshToken = result.get().getRefreshToken();
        System.out.println(refreshToken);


        Future<AuthenticationResult> result1 = context.acquireTokenByRefreshToken(
                refreshToken,
                new ClientCredential(APP_ID, APP_SECRET),
                null
        );

        String tokenNew = result1.get().getAccessToken();
        String refreshTokenNew = result1.get().getRefreshToken();
        System.out.println(tokenNew);
        System.out.println(refreshTokenNew);
    }
}