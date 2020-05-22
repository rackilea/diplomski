public Socket ConnectToServer(String normalSrv, int nrmPort, String backupSrv, int bckPort)
{
    // Let's try to connect to the Normal Server first.
    try
    {
        Socket retSocket = new Socket();
        InetAddress addr = InetAddress.getByName(normalSrv);
        SocketAddress sockaddr = new InetSocketAddress(addr, nrmPort);
        retSocket.connect(sockaddr, 30000); // 30 seconds timeout
        return retSocket;
    }
    catch (Exception e)
    {
        // can't connect to the Normal Server
        e.printStackTrace();
    }

    // Normal server is down, let's try to connect to the Backup Server.
    try
    {
        Socket retSocket = new Socket();
        InetAddress addr = InetAddress.getByName(backupSrv);
        SocketAddress sockaddr = new InetSocketAddress(addr, bckPort);
        retSocket.connect(sockaddr, 30000); // 30 seconds timeout
        return retSocket;
    }
    catch (Exception e)
    {
        // can't connect to the Backup Server
        e.printStackTrace();
    }
    // none of the server are available
    return null;
}

// Then, in your AsyncTask:
@Override
protected String doInBackground(String... params) {

    Socket socket = ConnectToServer(params[1], Integer.parseInt(params[2]), params[3], Integer.parseInt(params[4]));
    if (socket != null) 
    {
        try{ 
               PrintWriter output = new PrintWriter(socket.getOutputStream());    
               BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
               output.println(params[0]);
               output.flush();
               String read="";
               while((read=input.readLine())!=null)
               {
                  TheData=read;
               }
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        { 
            socket.close();                                                 
        }
        return TheData;