/**
  * @param token
  *    For all "real" API endpoints, pass in the access token here.
  *    For "/oauth/access_token", pass in the request token here.
  *    (For "/oauth/request_token", use {@link #buildInitialOAuthHeader}.)
  */
 public static HttpHeader buildOAuthHeader(AppInfo appInfo, Token token)
 {
     StringBuilder buf = new StringBuilder();
     buf.append("OAuth ");
     buf.append("oauth_token=\"").append(token.key).append("\"");
     buf.append(", oauth_consumer_key=\"").append(appInfo.key).append("\"");
     buf.append(", oauth_signature_method=\"PLAINTEXT\"");
     buf.append(", oauth_signature=\"").append(appInfo.secret).append("&").append(token.secret).append("\"");
     return new HttpHeader("Authorization", buf.toString());
 }

 /**
  * For "/oauth/request_token".
  */
 public static HttpHeader buildInitialOAuthHeader(AppInfo appInfo)
 {
     StringBuilder buf = new StringBuilder();
     buf.append("OAuth ");
     buf.append(" oauth_consumer_key=\"").append(appInfo.key).append("\"");
     buf.append(", oauth_signature_method=\"PLAINTEXT\"");
     buf.append(", oauth_signature=\"").append(appInfo.secret).append("&\"");
     return new HttpHeader("Authorization", buf.toString());
 }