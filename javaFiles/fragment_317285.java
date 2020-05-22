public static void send(SocketChannel socket,  Serializable serializable) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    for(int i=0;i<4;i++) baos.write(0);
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(serializable);
    oos.close();
    final ByteBuffer wrap = ByteBuffer.wrap(baos.toByteArray());
    wrap.putInt(0, baos.size()-4);
    socket.write(wrap);
}

private final ByteBuffer lengthByteBuffer = ByteBuffer.wrap(new byte[4]);
private ByteBuffer dataByteBuffer = null;
private boolean readLength = true;

public Serializable recv(SocketChannel socket) throws IOException, ClassNotFoundException {
    if (readLength) {
        socket.read(lengthByteBuffer);
        if (lengthByteBuffer.remaining() == 0) {
            readLength = false;
            dataByteBuffer = ByteBuffer.allocate(lengthByteBuffer.getInt(0));
            lengthByteBuffer.clear();
        }
    } else {
        socket.read(dataByteBuffer);
        if (dataByteBuffer.remaining() == 0) {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(dataByteBuffer.array()));
            final Serializable ret = (Serializable) ois.readObject();
            // clean up
            dataByteBuffer = null;
            readLength = true;
            return ret;
        }
    }
    return null;
}