public static boolean hasOracleSocketBug()
{
    try
    {
        int port = 10000;

        while(!PortChecker.portAvailable(port))
            port++;

        ServerSocket serverSocket = new ServerSocket(port);

        int fPort = port;
        new Thread(() -> {
            try
            {
                Socket socket = new Socket("localhost", fPort);
                OutputStream out = socket.getOutputStream();
                out.write(1);
                out.write(2);
                out.close();
                socket.close();
            }
            catch(Exception ex)
            {
                try
                {
                    serverSocket.close();
                }
                catch(IOException ignored) {}
            }
        }).start();

        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        in.read();
        socket.getOutputStream().write(3);

        try
        {
            in.read();
        }
        catch(Exception ex)
        {
            socket.close();
            return true;
        }

        in.close();
        socket.close();
        return false;
    }
    catch(Throwable ignored)
    {
        return false;
    }
}

public static boolean portAvailable(int port)
{
    ServerSocket ss = null;
    try
    {
        ss = new ServerSocket(port);
        ss.setReuseAddress(true);
        return true;
    }
    catch(IOException ignored)
    {
        return false;
    }
    finally
    {
        if(ss != null)
        {
            try
            {
                ss.close();
            }
            catch(IOException ignored) {}
        }
    }
}