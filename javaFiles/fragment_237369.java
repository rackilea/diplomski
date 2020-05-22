/**
 * Custom implementation of {@link HttpState} with credentials property.
 *
 * @author banterCZ
 */
public class CustomHttpState extends HttpState {

    /**
     * Set credentials property.
     *
     * @param credentials
     * @see #setCredentials(org.apache.commons.httpclient.auth.AuthScope, org.apache.commons.httpclient.Credentials)
     */
    public void setCredentials(final Credentials credentials) {
        super.setCredentials(AuthScope.ANY, credentials);
    }

}