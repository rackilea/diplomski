public void run() throws Exception {
    socket = listener.accept();

    obin = new ObjectInputStream(socket.getInputStream());
    int h = obin.readInt();
    System.out.println(h);

    obout = new ObjectOutputStream(socket.getOutputStream());
    obout.writeInt(77);
    obout.flush();
}