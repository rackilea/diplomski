/**
 * The domain for Temporary token.
 */
public class TemporaryToken extends AbstractToken {

    private Date expirationDate;
    private String refreshToken;

    // more attributes that makes general token as temporary token

    /**
     * Instantiates a new Temporary token with token expiry date and refresh token
     *
     * @param token          the token
     * @param expirationDate the expiration date
     * @param refreshToken   the refresh token
     */
    public TemporaryToken(String token, Date expirationDate, String refreshToken) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.refreshToken = refreshToken;
    }
}