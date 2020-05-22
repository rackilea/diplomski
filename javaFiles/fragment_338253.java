// change 192.168.154.169 to ip of your machine to test
    String[] hosts = { "192.168.154.169", "localhost", "google.com" };

    for (String host : hosts) {
        InetAddress address = InetAddress.getByName(host);
        boolean isLocalhost = "127.0.0.1".equals(address.getHostAddress())
                || InetAddress.getLocalHost().getHostAddress().equals(address.getHostAddress());
        System.out.println("Hostname: " + host + ", is local host: " + isLocalhost);
    }