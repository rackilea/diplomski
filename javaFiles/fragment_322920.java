HttpResponse wsResponse = WS.url(comercialYComunUrl).get();
String responseString = wsResponse.getString("ISO-8859-1");

if (wsResponse.getStatus() == 200) {
  List<Header> headers = wsResponse.getHeaders();
  // get all the cookies
  List<String> cookies = new ArrayList<String>();
  for (Header header: headers) {
    if (header.name.equals("Set-Cookie")) {
      cookies = header.values;
    }
  }
  // look for the session cookies
  String sessionCookie = "";
  for (String cookie : cookies) {
    if (cookie.toUpperCase().contains("ASPSESSIONID")) {
      sessionCookie = cookie.split(";", 2)[0];
    }
  }
  // store it on the session
  session.put("COOKIE", sessionCookie);
}