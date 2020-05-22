final HttpClient client = new DefaultHttpClient();
final HttpPost post = new HttpPost(
        "http://www.xtratime.org/forum/login.php?do=login");
try {
    final List<NameValuePair> nameValuePairs = 
        new ArrayList<NameValuePair>(1);
    nameValuePairs.add(new BasicNameValuePair("vb_login_username",
            "my user"));
    nameValuePairs.add(new BasicNameValuePair("vb_login_password", ""));
    nameValuePairs.add(new BasicNameValuePair("s", ""));
    nameValuePairs.add(new BasicNameValuePair("securitytoken",
            "inspected with httpfox, like f48d01..."));
    nameValuePairs.add(new BasicNameValuePair("do", "login"));
    nameValuePairs.add(new BasicNameValuePair("vb_login_md5password",
            "inspected with httpfox, like 8e6ae1..."));
    nameValuePairs.add(new BasicNameValuePair(
            "vb_login_md5password_utf",
            "inspected with httpfox, like 8e6ae1..."));

    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    final HttpResponse response = client.execute(post);
    final BufferedReader rd = new BufferedReader(new InputStreamReader(
            response.getEntity().getContent()));
    String line = "";
    while ((line = rd.readLine()) != null) {
        System.out.println(line);
    }
} catch (final IOException e) {
    e.printStackTrace();
}