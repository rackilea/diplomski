Socket socket = new Socket("vortex.labs.overthewire.org", 5842);
DataInputStream in = new DataInputStream(socket.getInputStream());

byte[] intData = new byte[4];

for (int i = 0; i < 4; i++) {
    in.readFully(intData);
    System.out.println(ByteBuffer.wrap(intData)
            .order(ByteOrder.LITTLE_ENDIAN).getInt());
}