public void getFavicon(String host) {

    URL httpUrl = this.getHttpUrl(host + "/favicon.ico");

    Bitmap favicon = this.getBitmap(httpUrl);

    if (favicon == null) {

        URL httpsUrl = this.getHttpsUrl(host + "/favicon.ico");

        favicon = this.getBitmap(httpsUrl);
    }

    if (favicon == null) {

        throw new FaviconMissingException("Unable to find favicon for host: " + host);
    }

    return favicon;
}

public URL getHttpUrl(String uri) throws MalformedURLException {

    // There are better ways of building a url then string concationation.
    return new URL("http://" + uri);
}

public URL getHttpsUrl(String uri) throws MalformedURLException {

    // There are better ways of building a url then string concationation.
    return new URL("https://" + uri);
}

public Bitmap getBitmap(URL url) {

    InputStream inputStream = getInputStream(url);

    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

    return bitmap
}

public InputStream getInputStream(URL url) {

    // Please use a real connection library like HTTPClient here!
    // HttpClient will handle timeouts, redirects, and things like that for you.
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoInput(true);
    connection.connect();

    return connection.getInputStream();
}