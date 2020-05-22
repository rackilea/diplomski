public class CustomTokenGranter extends AbstractTokenGranter {

    //...

    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {

        Map<String, String> params = tokenRequest.getRequestParameters();
        String username = params.getOrDefault("username", null);
        String password = params.getOrDefault("password", null);

        if(username == null || password == null)
            throw new BadCredentialsException("Bad credentials");

        CustomAuthenticationToken token = new CustomAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(token);

    }
}