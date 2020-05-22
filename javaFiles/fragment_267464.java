public class DummyAccessTokenService implements AccessTokenService {

    private volatile String currentToken = null;

    @Override
    public String fetchAccessToken() {
        return currentToken;
    }

    private int tokenNumber = 0;

    @Override
    public void refreshAccessToken() {
        currentToken = String.format("Token-%d", tokenNumber++);
    }

}