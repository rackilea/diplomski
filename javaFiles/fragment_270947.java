public void checkURL(URL url) throws IOException {
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    System.out.println(String.format("Fetching %s ...", url));
    try {
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            System.out.println(String.format("Site is up, content length = %s", conn.getHeaderField("content-length")));
        } else {
            System.out.println(String.format("Site is up, but returns non-ok status = %d", responseCode));
        }
    } catch (java.net.UnknownHostException e) {
        System.out.println("Site is down");
    }
}