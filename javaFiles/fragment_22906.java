public class ChatServer extends JFrame implements Runnable
{
    private ChatServer()
    {
        this.setGUI();
        this.setVisible(true);
        try
        {
            serverSocket = new ServerSocket(port);
            Thread accept = new Thread(this);
            accept.setDaemon(true);
            accept.start();
        } catch (IOException ex)
        {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }