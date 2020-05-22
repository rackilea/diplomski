public class EchoServer {

    public static void main(String[] args) {

        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        while (true) {

            //wait for next client to connect
            Socket cliSocket = server.accept();

            //hand off socket to another thread
            MyHandler handler = new MyHandler(cliSocket);
            Thread clientHandler = new Thread(handler);
            clientHandler.start();    
        }
    }
}

public class MyHandler implements Runnable {

    public MyHandler(Socket cliSocket)
    {
        //store socket
    }

    @override
    public void run()
    {
        while(true) {
            //handle client comms
        }
    }
}