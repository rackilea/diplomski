ServerSocket servsock = new ServerSocket(12345);
while (true) {
    Socket sock = servsock.accept();
    try (DataInputStream dis = new DataInputStream(sock.getInputStream())) {
        int len = dis.readInt();
        byte[] mybytearray = new byte[len];
        dis.readFully(mybytearray);
        try (FileOutputStream fos = new FileOutputStream("myfile.txt")) {
            fos.write(mybytearray);
        }
        len = dis.readInt();
        mybytearray = new byte[len];
        dis.readFully(mybytearray);
        String line = new String(mybytearray);
        System.out.println("line = " + line);
    }
}