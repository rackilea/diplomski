try {
    // ...
    s = new Socket();
    s.connect(new InetSocketAddress(ip,port));
    // ...
}
catch (IOException e) {
    // Here lays an answer for your issue, just log it and see the cause.
    e.printStackTrace();   // As suggested by @gabe-sechan.
}