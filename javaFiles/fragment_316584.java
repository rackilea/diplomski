public class TokenHelper {

private static Logger logger = LoggerFactory.getLogger(TokenHelper.class);

private static final int HTTP_TIMEOUT_MILISEC = 100000;
private static String lineSeparator = System.getProperty("line.separator");

@Value("#{'${hostname}'}")
private String hostName;

@Value("#{'${port}'}")
private int port;

@Value("#{'${contextpath}'}")
private String contextPath;

@Value("#{'${isbasicauthentication}'}")
private boolean isBasicAuthentication;

@Value("#{'${username}'}")
private String basicAuthenticationUserName;

@Value("#{'${userpassword}'}")
private String basicAuthenticationPassword;

public Map<String, String> getLtpaToken() throws Exception {    
    Cookie[] cookies = null;
    Protocol protocol = null;
    Map<String, String> cookiesMap = new HashMap<String, String>();

    GetMethod method = new GetMethod();
    HttpClient client = new HttpClient();
    method.getParams().setSoTimeout(HTTP_TIMEOUT_MILISEC);
    protocol = new Protocol("http", new DefaultProtocolSocketFactory(), getPort());

    if (isBasicAuthentication) {
        client.getParams().setAuthenticationPreemptive(true);
        Credentials defaultcreds = new UsernamePasswordCredentials(getBasicAuthenticationUserName(), getBasicAuthenticationPassword());
        client.getState().setCredentials(new AuthScope(getHostName(), getPort(), AuthScope.ANY_REALM), defaultcreds);
    }
    // Execute request
    try {
        client.getHostConfiguration().setHost(getHostName(), getPort(), protocol);
        method = new GetMethod(getContextPath());
        method.setFollowRedirects(true);

        logger.info(methodName, "URL to get:" + getContextPath());
        // Execute the GET method           
        int statusCode = client.executeMethod(method);
        if (statusCode != -1) {
            cookies = client.getState().getCookies();

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < cookies.length; j++) {
                cookiesMap.put(cookies[j].getName(), cookies[j].getValue());
                sb.append("CookieName=" + cookies[j].getName() + lineSeparator);
                sb.append("Value=" + cookies[j].getValue() + lineSeparator);
                sb.append("Domain=" + cookies[j].getDomain() + lineSeparator);
            }
            sb.append("Status Text>>>" + HttpStatus.getStatusText(statusCode));
            logger.debug("Cookies are: {}" + sb.toString());

            method.releaseConnection();

        }
    } catch (Exception e) {
        logger.error("Error while getting LTPA token using HttpBasicAuthentication for URL {}" +e);
        throw new RuntimeException("Error while getting LTPA token using HttpBasicAuthentication for URL:" + contextPath, e);
    } finally {
        // Release current connection to the connection pool once you
        // are done
        method.releaseConnection();
    }
    return cookiesMap;
}