String content = "<html><body>123 Hello World</body></html>";
    Writer wrtr = new OutputStreamWriter(sok.getOutputStream());
    wrtr.write("HTTP/1.1 200 OK\n");
    wrtr.write("Content-Type: text/html; charset=UTF-8\n");
    //assuming content is pure ascii
    wrtr.write("Content-Length: " + content.length() + "\n");
    wrtr.write("Connection: close\n\n");
    wrtr.write(content);
    wrtr.flush();
    //then close the connection, do not reuse the connection
    //as you might not have consumed the full request content