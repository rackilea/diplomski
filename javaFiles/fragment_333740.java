public Client() throws Exception {
    String serverAddress = "127.0.0.1";
    socket = new Socket(serverAddress, 9001);

    oot = new ObjectOutputStream(socket.getOutputStream());
    oot.writeInt(66);
    oot.flush();

    oin = new ObjectInputStream(socket.getInputStream());
    int u = oin.readInt();
    System.out.println(u);
}