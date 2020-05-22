Socket sock = new Socket("127.0.0.1", 12345);
File file = new File("file.txt");
byte[] mybytearray = new byte[(int) file.length()];
DataInputStream dis = new DataInputStream(new FileInputStream(file));
dis.readFully(mybytearray);
try(DataOutputStream os = new DataOutputStream(sock.getOutputStream())) {
    os.writeInt(mybytearray.length);
    os.write(mybytearray, 0, mybytearray.length);
    String nextMessage = "next message\n";
    byte message[] = nextMessage.getBytes();
    os.writeInt(message.length);
    os.write(message, 0, message.length);
}