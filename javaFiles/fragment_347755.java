private static void useProxy(String host, int port)
{
    System.setProperty("http.proxySet", "true");
    System.setProperty("http.proxyHost", host);
    System.setProperty("http.proxyPort", String.valueOf(port));
}