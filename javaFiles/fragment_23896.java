public class FaceBookSecurity {

// return the fb user in the cookie.
public static String getFBUserFromCookie(HttpServletRequest request)
        throws Exception {
    Cookie fbCookie = getFBCookie(request);

    if (fbCookie == null)
        return null;

    // gets cookie value
    String fbCookieValue = fbCookie.getValue();

    // splits it.
    String[] stringArgs = fbCookieValue.split("\\.");
    String encodedPayload = stringArgs[1];

    String payload = base64UrlDecode(encodedPayload);

    // gets the js object from the cookie
    JsonObject data = new JsonObject(payload);

    return data.getString("user_id");

}

public static boolean ValidateFBCookie(HttpServletRequest request)
        throws Exception {

    Cookie fbCookie = getFBCookie(request);

    if (fbCookie == null)
        throw new NotLoggedInFacebookException();

    // gets cookie information
    String fbCookieValue = fbCookie.getValue();

    String[] stringArgs = fbCookieValue.split("\\.");
    String encodedSignature = stringArgs[0];
    String encodedPayload = stringArgs[1];

    //decode
    String sig = base64UrlDecode(encodedSignature);
    String payload = base64UrlDecode(encodedPayload);

    // gets the js object from the cookie
    JsonObject data = new JsonObject(payload);

    if (!data.getString("algorithm").Equals("HMAC-SHA256")) {
        return false;
    }

    SecretKey key = new SecretKeySpec(
            ApplicationServerConstants.FacebookSecretKey.getBytes(),
            "hmacSHA256");

    Mac hmacSha256 = Mac.getInstance("hmacSHA256");
    hmacSha256.init(key);
    // decode the info.
    byte[] mac = hmacSha256.doFinal(encodedPayload.getBytes());

    String expectedSig = new String(mac);

    // compare if the spected sig is the same than in the cookie.
    return expectedSig.equals(sig);

}

public static String getFBAccessToken(HttpServletRequest request)
        throws Exception {
    Cookie fbCookie = getFBCookie(request);

    String fbCookieValue = fbCookie.getValue();

    String[] stringArgs = fbCookieValue.split("\\.");
    String encodedPayload = stringArgs[1];

    String payload = base64UrlDecode(encodedPayload);

    // gets the js object from the cookie
    JsonObject data = new JsonObject(payload);

    String authUrl = getAuthURL(data.getString("code"));
    URL url = new URL(authUrl);
    URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(),
            url.getQuery(), null);
    String result = readURL(uri.toURL());

    String[] resultSplited = result.split("&");

    return resultSplited[0].split("=")[1];

}

// creates the url for calling to oauth.
public static String getAuthURL(String authCode) {
    String url = "https://graph.facebook.com/oauth/access_token?client_id="
            + ApplicationConstants.FacebookApiKey
            + "&redirect_uri=&client_secret="
            + ApplicationServerConstants.FacebookSecretKey + "&code="
            + authCode;

    return url;
}

// reads the url.
private static String readURL(URL url) throws IOException {

    InputStream is = url.openStream();

    InputStreamReader inStreamReader = new InputStreamReader(is);
    BufferedReader reader = new BufferedReader(inStreamReader);

    String s = "";

    int r;
    while ((r = is.read()) != -1) {
        s = reader.readLine();
    }

    reader.close();
    return s;
}

private static String base64UrlDecode(String input) {
    String result = null;
    Base64 decoder = new Base64(true);
    byte[] decodedBytes = decoder.decode(input);
    result = new String(decodedBytes);
    return result;
}

    private static Cookie getFBCookie(HttpServletRequest request) 
    {
        Cookie[] cookies = request.getCookies();

        if (cookies == null)
            return null;

        Cookie fbCookie = null;

        for (Cookie c : cookies) {
            if (c.getName().equals(
                "fbsr_" + ApplicationServerConstants.FacebookApiKey)) {
                fbCookie = c;
            }
        }
        return fbCookie;
    }
}