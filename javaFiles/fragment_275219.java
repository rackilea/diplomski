URL url = new URL("https://api.del.icio.us/v1/posts/suggest");
    byte[] b64 = Base64.encodeBase64("username:pass".getBytes());
    URLConnection conn = url.openConnection();
    conn.setRequestProperty("Authorization", "Basic " + new String(b64));
    BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    while(r.ready()){
        System.out.println(r.readLine());
    }