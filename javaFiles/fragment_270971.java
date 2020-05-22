public DefaultHttpClient getHttpclient() {
DefaultHttpClient httpclient = new DefaultHttpClient();
if (cookies != null) {
      int size = cookies.size();
      for (int i = 0; i < size; i++) {
          httpclient.getCookieStore().addCookie(cookies.get(i));
      }
 }

 // you have also set your extra properties of httpclient like user-agent and time etc. here
    return httpclient;
}