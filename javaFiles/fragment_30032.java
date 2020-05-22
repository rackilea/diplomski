protected URLConnection newURLConnection(URL pURL) throws IOException {
    URLConnection urlConnection = super.newURLConnection(pURL);

    String auth = new String(Base64.base64Encode(new String("username:password").getBytes()));
    auth = "Basic " + auth;
    urlConnection.setRequestProperty("Proxy-Connection","Keep-Alive");
    urlConnection.setRequestProperty("Proxy-Authorization",auth);
    return urlConnection;
}