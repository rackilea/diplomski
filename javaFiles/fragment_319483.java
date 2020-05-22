String url = "http://example.com/j_security_check?j_username=foo&j_password=bar";
HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

if (connection.getResponseCode() == 200) { // 200 = OK, 401 = unauthorized
    String cookie = connection.getHeaderField("Set-Cookie").split(";", 2)[0];

    url = "http://example.com/somepage.jsp";
    connection = (HttpURLConnection) new URL(url).openConnection();
    connection.setRequestProperty("Cookie", cookie);
    InputStream input = connection.getInputStream();
    // You can now write it to response.getOutputStream().
}