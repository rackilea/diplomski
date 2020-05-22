/**
 * The domain encapsulates the behaviour of Permanent token - token that never expires
 */
public class PermanentToken extends AbstractToken {

    // more attributes that makes general token as Parmament token

    /**
     * Instantiates a new Permanent token - this token never expires
     *
     * @param token the token
     */
    public PermanentToken(String token) {
        this.token = token;
    }
}