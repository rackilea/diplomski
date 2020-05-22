String url = "http://whatever.com/script.php?argument=value";
HttpClient client = new DefaultHttpClient();

try {
    client.execute(new HttpGet(url));
} catch(IOException e) {
    // something happened
}