public static HttpHeaders getXSRF() {
    try {
    HttpEntity<String> responseEntity = restTemplate.exchange(urlBase, HttpMethod.GET, null, String.class);
    CookieManager cookieManager = new CookieManager();
    List<String> cookieHeader = responseEntity.getHeaders().get("Set-Cookie");
    httpHeaders = new HttpHeaders();
    httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    if (cookieHeader != null) {
        for (String cookie : cookieHeader) {
            String[] tokens = TextUtils.split(cookie, "=");
            if (tokens[0].equals("XSRF-TOKEN")) {
                String[] tokenValue = TextUtils.split(tokens[1],";");
                httpHeaders.add("X-XSRF-TOKEN", tokenValue[0]);
            }
            if (tokens[0].equals("JSESSIONID"))
                httpHeaders.add("Cookie", cookie);
        }
    }
    } finally {
        return httpHeaders;
    }
}