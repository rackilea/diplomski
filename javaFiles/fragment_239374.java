Socket socket= new Socket();
    SocketAddress endpoint= new InetSocketAddress("www.google.com", 80);
    socket.connect(endpoint);
    InetAddress localAddress = socket.getLocalAddress();
    socket.close();
    System.out.println(localAddress.getHostAddress());
    NetworkInterface ni = NetworkInterface.getByInetAddress(localAddress);
    byte[] mac = ni.getHardwareAddress();
    StringBuilder s=new StringBuilder();
    if (mac != null){
        for(int j=0; j < mac.length; j++) {
                                String part = String.format("%02X%s", mac[j], (j < mac.length - (1)) ? "" : "");
                                s.append(part);
        }

        System.out.println("MAC:" + s.toString());
    }
    else{
        System.out.println("Address doesn't exist or is not accessible.");
    }