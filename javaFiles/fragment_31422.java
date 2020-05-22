public static String readRSS(String urlAddress) {

System.setProperty("http.proxyHost", YOUR_PROXY_HOST);
System.setProperty("http.proxyPort", YOUR_PROXY_PORT);

//Below 2 for authenticated proxies only
System.setProperty("http.proxyUser", YOUR_USERNAME);
System.setProperty("http.proxyPassword", YOUR_PASSWORD);

 try {
    ...