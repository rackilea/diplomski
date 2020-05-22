URL url = new URL("http://some.url");
    int responseCode = -1;
    while (responseCode != 200) {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        responseCode = conn.getResponseCode();
        if (responseCode > 299 && responseCode < 400) {
            url = new URL(conn.getHeaderField("Location"));
        }
    }