for (int z = 0; z < 100; z++) {
    String ip = "10.0.0." + z;
        try {
            log(ip);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, MainActivity._util.getPort()), 1000);
            // Handle Stuff when Exception NOT throw
        } catch (Exception e) {
        }
}