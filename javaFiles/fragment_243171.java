public static boolean testAvailablility(int port, String responseStartsWith) {
    boolean toReturn = false;

    try {
        Socket client1 = new Socket();
        client1.setSoTimeout(10000);
        client1.bind(new InetSocketAddress("localhost", port));
        InputStream stream = client1.getInputStream();
        byte[] response = new byte[4096];
        int bytes = 0;
        String serverReturnString = null;
        bytes = stream.read(response, 0, response.length);
        serverReturnString = String.valueOf(bytes);
        System.out.println("TestAvailablility: serverReturnString = {0} " + serverReturnString);
        if (serverReturnString.toLowerCase().startsWith(responseStartsWith.toLowerCase()))
            toReturn = true;
    } catch (Exception ex) // SocketException for connect, IOException for
                            // the read.
    {
        System.out.println("TestAvailable - Could not connect to VNC server.  Exception info: ");
        ex.printStackTrace();
    }

    return toReturn;
}