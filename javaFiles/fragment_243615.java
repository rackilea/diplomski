dis = new DataInputStream(sock.getInputStream());
try {
    for(;;) {
      int id = dis.readInt(o);
      String name = dis.readUTF();
      ...
      MyObject obj = new MyObject(id, name, ...);
    }
} catch(EOFException ex) {
        // ignore, client closed OutputStream
}