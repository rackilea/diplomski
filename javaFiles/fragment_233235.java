System.setProperty("http.proxyHost", "host");
    System.setProperty("http.proxyPort", "port");
    try {
        URL u = new URL("some url");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        InputStream is = null;
        if (huc.getResponseCode() == HttpURLConnection.HTTP_OK)
            is = huc.getInputStream();
        else
            is = huc.getErrorStream();
    } catch (Exception e) {
        e.printStackTrace();
    }