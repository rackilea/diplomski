Socket sock = new Socket("host", port);
    OutputStream out = sock.getOutputStream();
    out.write(0);
String s = "ravi";
    byte[] bytes = s.getBytes("UTF-8");
    out.write(bytes);