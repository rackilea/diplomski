URL url = new URL("https://ajax.googleapis.com/ajax/services/feed/find?" +
            "v=1.0&q=Official%20Google%20Blog");
    URLConnection connection = url.openConnection();

    ByteArrayOutputStream content = new ByteArrayOutputStream();

    InputStream is = connection.getInputStream();
    int len = 0;
    byte[] buffer = new byte[1024];
    while ((len = is.read(buffer)) >= 0)
    {
        content.write(buffer, 0, len);
    }
    byte[] finalContent = content.toByteArray();
    String str = new String(finalContent, "UTF8");
    System.out.print(str);