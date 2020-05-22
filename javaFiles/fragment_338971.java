DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

int len = in.readInt(); // read big-endian.
if (LITTLE_ENDIAN)
    len = Integer.reverseBytes(len);
byte[] bytes = new byte[len];
in.readFully(bytes);