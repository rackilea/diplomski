@Override
public void run()
{
    connector: while (true)
    {
        Socket socket = new Socket();

        try
        {
            socket.connect(new InetSocketAddress("0.0.0.0", 9999), 2000);
            this.doSomethingElseWithConnectedSocket(socket);
            break connector; // break out of the while loop
        }
        catch (ConnectException e)
        {
            // ignore because worthless
        }

        try
        {
             socket.close();
        }
        catch(Throwable x)
        {
             // ignore
        }

        System.out.println("Unable to connect to server ");

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e1)
        {
            // ignore
        }
    }
}

public void doSomethingElseWithConnectedSocket(Socket value)
{
     value.close(); // close for no good reason
}