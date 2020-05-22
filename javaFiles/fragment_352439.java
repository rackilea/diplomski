import java.io.IOException;
import java.net.ServerSocket;

public class ServAccept implements Runnable
{
    private ServerSocket serv;
    private ConnectionReceivedListener listener;

    public ServAccept( ServerSocket sock,ConnectionReceivedListener con )
    {
        this.serv = sock;
        this.listener = con;
    }

    @Override
    public void run()
    {
        try
        {
            listener.onConnectionReceived( new ConnectionReceivedEvent( serv.accept() ) );
        } catch (IOException e)
        {
            // planned exception here.
        }
    }
}