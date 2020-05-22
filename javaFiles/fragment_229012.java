static void client() throws IOException, ClassNotFoundException {
    Socket socket = new Socket("localhost", 3434);
    InputStream in = socket.getInputStream();
    ObjectInputStream oin = new ObjectInputStream(in);
    String stringFromServer = (String) oin.readObject();
    FileWriter writer = new FileWriter("received.txt");
    writer.write(stringFromServer);
    in.close();
    writer.close();
}