ProxiedHttpsConnection n = new ProxiedHttpsConnection(
            new URL("https://stackoverflow.com:443/questions/3304006/persistent-httpurlconnection-in-java"), 
            "proxy.example.com", 8080, "root", "flg83yvem#");
    n.setRequestMethod("GET");
    n.addRequestProperty("User-Agent", "Java test https://stackoverflow.com/users/1542723/ferrybig");
    //try (OutputStream out = n.getOutputStream()) {
    //  out.write("Hello?".getBytes());
    //}
    try (InputStream in = n.getInputStream()) {
        byte[] buff = new byte[1024];
        int length;
        while ((length = in.read(buff)) >= 0) {
            System.out.write(buff, 0, length);
        }
    }