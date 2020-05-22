Proxy proxy = new Proxy(Proxy.Type.HTTP, 
            new InetSocketAddress("np1prxy801.corp.abc.com", 80));
    URL url=new URL(sUrl);
    HttpURLConnection con = (HttpURLConnection)url.openConnection(proxy);

    String user = "user";
    String password = "password";
    Authenticator.setDefault(
       new Authenticator() {
          @Override
          public PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(
                   user, password.toCharArray());
          }
       }
    );

    con.setRequestMethod("GET");
    InputStream is = con.getInputStream();