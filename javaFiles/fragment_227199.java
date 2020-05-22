URL url = new URL("http://google.com");
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    conn.setDoOutput(true);
    OutputStream    out = conn.getOutputStream();
    out.write("xxxx=yyyy".getBytes());
    out.flush();
    int responseCode = conn.getResponseCode();
    System.out.println("responseCode="+responseCode);
    InputStream in = (responseCode == 200) ? conn.getInputStream() : conn.getErrorStream();
    int c;
    while ((c = in.read()) != -1)
    {
        System.out.write(c);
    }
    in.close();
    conn.disconnect();