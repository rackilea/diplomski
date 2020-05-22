public class SocketMessageSender
{
    private String host;
    private int port;
    private DataOutputStream dos;

    public SocketMessageSender(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    // call when application starts
    public void initConnection() throws IOException
    {
        InetAddress address = InetAddress.getByName(host);
        Socket connection = new Socket(address, port);
        dos = new DataOutputStream(connection.getOutputStream());
    }

    //call from button click
    public void sendMessage(String message) throws IOException
    {
        if(dos != null)
        {
            dos.writeUTF(message);
            dos.flush();
        }
    }

    // call when application exits
    public void closeConnection() throws IOException
    {
        if(dos!= null)
        {
            dos.close();
        }
    }
}