public class TCPServer {
    // ...
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(PORT)) {
            // Accepts infinite clients.
            while (true) {
                try (Socket cs = ss.accept();
                     DataInputStream in = new DataInputStream(client.getInputStream())) {
                    boolean isClientOpen = true;
                    while (isClientOpen) {
                        try {
                            Message message = decode(in);
                            System.out.print("Message received: " + message.getMessage() + " id: " + message.getId());
                        } catch (IOException e) {
                            // The client may have closed the socket.
                            isClientOpen = false;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Message decode(DataInputStream in) throws IOException {
        Message message = new Message();
        message.setMessage(in.readUTF());
        message.setId(in.readInt());
        return message;
    }
}