String buff0 = "03";
    String buff1 = "0300";
    String buff2 = "8028";

    String packet = buff0 + buff1 + buff2;

    byte[] b = new BigInteger(packet,16).toByteArray();



    try {
        Socket socket = new Socket("192.168.0.2", 22);
        OutputStream socketOutputStream = socket.getOutputStream();
        socketOutputStream.write(b);
        InputStream socketInput = socket.getInputStream();
        System.out.println(socketInput.read());
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }