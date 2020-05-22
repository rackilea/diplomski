public class Main {
    public static void main(String[] args) throws IOException {
         ServerSocket serverSocket = new ServerSocket(50505);
         while (true) {
             Socket socket = serverSocket.accept();
             SocketHandler h = new SocketHandler(socket);
             h.start();
         }
    }
}

public class SocketHandler extends Thread{

    Socket clientSock;
    public SocketHandler(Socket sock){
        clientSock = sock;
    }

    public void run(){
        while(clientSock.isConnected()) {
            String v;
            DataInputStream in;
            InputStream in_sock;
            in_sock = socket.getInputStream();
            in = new DataInputStream(in_sock);
            v = in.readLine();
            System.out.println(v);
            OutputStream output = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(output);
            out.writeChars("123\n");
            out.writeChars("123\n");
            out.writeChars("123\n");
        }
    }
}