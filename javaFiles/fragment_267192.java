...
URL url = new URL("http://www.google.com");
URLConnection urlConnection;
Proxy = getProxy();
if(proxy != null) {
    urlConnection = url.openConnection(proxy);
} else {
    urlConnection = url.openConnection();
HttpURLConnection connection = null;
...