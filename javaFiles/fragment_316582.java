URL url = new URL("http://www.myurl.com");

Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.com", 8080));

// IF NEED AUTH         
//      Authenticator authenticator = new Authenticator() {
//          public PasswordAuthentication getPasswordAuthentication() {
//              return (new PasswordAuthentication("username",
//                      "password".toCharArray()));
//          }
//      };
//      Authenticator.setDefault(authenticator);

        HttpURLConnection conn = (HttpURLConnection)url.openConnection(proxy);
        conn.setRequestMethod("GET");
        conn.connect();

        int code = conn.getResponseCode();

        System.out.println(code);