public void send(File file, OutputStream os) throws IOException {
    DataOutputStream dos = new DataOutputStream(os);

    // writing name
    dos.writeUTF(file.getName());
    // writing length
    dos.writeLong(file.length());

    // writing file content
    ... your write loop, write to dos

    dos.flush();
}

public void receive(InputStream is) throws IOException {
    DataInputStream dis = new DataInputStream(is);

    String fileName = dis.readUTF();
    long fileSize = dis.readLong();

    // reading file content
    ... your read loop, read from dis
}