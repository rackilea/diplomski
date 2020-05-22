public class TestTcpClientServer
{
    public static final int SERVER_PORT = 10111;

    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        server.start();

        Thread.sleep(500);

        Client client = new Client();
        client.start();

        System.out.println("Press enter to shutdown...");

        System.in.read();

        client.shutdown();
        client.join();
        server.shutdown();
        server.join();

        System.out.println("Done.");
    }

    public static class Client extends Thread
    {
        private volatile boolean shutdown = false;

        public void run()
        {
            try
            {
                int totalClientConnections = 0;

                while (!shutdown)
                {
                    Socket socket = new Socket("localhost", SERVER_PORT);

                    InputStream inputStream = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                    OutputStream outputStream = socket.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

                    bw.write("Client saying hello to server");
                    bw.newLine();
                    bw.flush();

                    String readLine = br.readLine();
                    //System.out.println("Client read from server: " + readLine);

                    System.out.println("Socket local port: " + socket.getLocalPort());

                    socket.close();

                    totalClientConnections++;
                    if (totalClientConnections % 10000 == 0)
                    {
                        System.out.println("totalClientConnections=" + totalClientConnections);
                    }

                    Thread.sleep(1000);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public void shutdown()
        {
            shutdown = true;
        }
    }

    public static class Server extends Thread
    {
        private volatile boolean shutdown = false;
        private ServerSocket serverSocket = null;

        public void run()
        {
            try
            {
                int totalServerConnections = 0;

                serverSocket = new ServerSocket(SERVER_PORT);

                while (!shutdown)
                {
                    Socket socket = serverSocket.accept();

                    InputStream inputStream = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

                    OutputStream outputStream = socket.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

                    String readLine = br.readLine();
                    //System.out.println("Server read from client: " + readLine);

                    bw.write("Server saying hello to client");
                    bw.newLine();
                    bw.flush();

                    socket.close();

                    totalServerConnections++;
                    if (totalServerConnections % 10000 == 0)
                    {
                        System.out.println("totalServerConnections=" + totalServerConnections);
                    }
                }
            }
            catch (Exception e)
            {
                if (!shutdown)
                {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown()
        {
            shutdown = true;
            try
            {
                serverSocket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}