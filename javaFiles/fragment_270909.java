public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5555);
        List<DataOutputStream> doss = new ArrayList<>();
        while (true) {
            Socket client = server.accept();
            synchronized(doss) {
                doss.add(new DataOutputStream(client.getOutputStream()));
            }
            new Thread(new Runnable() {
                public void run() {
                    try (DataInputStream dis = new DataInputStream(client.getInputStream())) {
                        while (true) {                    // <---------  per-client loop
                            String message=dis.readUTF();
                            synchronized (doss) {
                                for (DataOutputStream dos : doss)
                                    dos.writeUTF(message);
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
    }
}