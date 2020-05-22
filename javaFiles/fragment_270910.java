public class ChatClient {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your nick: ");
        String name = s.nextLine();
        Socket socket = new Socket("localhost", 5555);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            public void run() {
                try {
                    while (true)                              // <------- receiver loop, in thread
                        System.out.println(dis.readUTF());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
        dos.writeUTF(name + " has joined the conversation");
        while (true)                                          // <------- sender loop
            dos.writeUTF(name + ": " + s.nextLine());
    }
}