/**
 * 
 */
package com.neurologic.example;

import javax.servlet.http.HttpServletRequest;

import net.oauth.signature.OAuthSignature;
import net.oauth.signature.impl.OAuthHmacSha1Signature;
import net.oauth.token.v1.AccessToken;
import net.oauth.token.v1.RequestToken;

import com.neurologic.oauth.service.impl.OAuth1Service;

/**
 * @author Buhake Sindi
 * @since 31 May 2011
 *
 */
public class TwitterOAuthService extends OAuth1Service {

    public static final String TWITTER_REQUEST_TOKEN_SESSION = "TWITTER_REQUEST_TOKEN_SESSION";
    public static final String TWITTER_ACCESS_TOKEN_SESSION = "TWITTER_ACCESS_TOKEN_SESSION";

    /* (non-Javadoc)
     * @see com.neurologic.oauth.service.impl.OAuth1Service#getOAuthSignature()
     */
    @Override
    protected OAuthSignature getOAuthSignature() {
        // TODO Auto-generated method stub
        return new OAuthHmacSha1Signature();
    }

    /* (non-Javadoc)
     * @see com.neurologic.oauth.service.impl.OAuth1Service#getRealm()
     */
    @Override
    protected String getRealm() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.neurologic.oauth.service.impl.OAuth1Service#getRequestToken(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected RequestToken getRequestToken(HttpServletRequest request) {
        // TODO Auto-generated method stub
        return (RequestToken) request.getSession().getAttribute(TWITTER_REQUEST_TOKEN_SESSION);
    }

    /* (non-Javadoc)
     * @see com.neurologic.oauth.service.OAuthService#saveAccessToken(javax.servlet.http.HttpServletRequest, java.lang.Object)
     */
    @Override
    public void saveAccessToken(HttpServletRequest request, AccessToken accessToken) {
        // TODO Auto-generated method stub
        request.getSession().setAttribute(TWITTER_ACCESS_TOKEN_SESSION, accessToken);
    }
}