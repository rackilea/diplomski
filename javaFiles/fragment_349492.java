@Override
public void run() 
{
    try
    {
        initWebClientListener();
    }
    finally
    {
        try 
        {
            serverSocket.close();
        } 
        catch (IOException ex1) 
        {}
    }
}