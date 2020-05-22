private Cookie login(URI targetUri, String loginPath, Map<String, String> params) throws IOException {
    requireNonNull(targetUri);
    requireNonNull(loginPath);

    // Keep track of cookies we might receive in an HttpClient:
    final CookieStore cookies = new BasicCookieStore();

    // Build and work with an (AutoCloseable) HttpClient that uses the cookie store:
    try (CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookies).build()) {

        // Prepare (login) request parameters:
        List<NameValuePair> reqParams = new ArrayList<>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                reqParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        // Execute the login (POST) request with the given parameters:
        HttpPost post = new HttpPost(targetUri + loginPath);
        post.setEntity(new UrlEncodedFormEntity(reqParams));

        CloseableHttpResponse response = client.execute(post);
        // Eventually, check the response to see if successful
        response.close();

        // Look for a JSESSIONID-named cookie stored in the HttpClient and return it to be used by calling code:
        for (org.apache.http.cookie.Cookie cookie : cookies.getCookies()) {
            if ("JSESSIONID".equalsIgnoreCase(cookie.getName())) {

                String domain = targetUri.getHost();
                if (domain.startsWith("www.")) {
                    domain = domain.substring(4);
                }

                Cookie authCookie = new Cookie(cookie.getName(), cookie.getValue());
                authCookie.setDomain(domain);
                authCookie.setPath("/");
                // Eventually, set expiry (to allow longer login) and other things...

                return authCookie;
            }
        }

        return null; // some sort of error?
    }
}