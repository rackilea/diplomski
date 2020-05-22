@Override
    protected synchronized void doDispatch(MuleEvent event) throws Exception
    {
        Socket socket = connector.getSocket(endpoint);
        try 
        {
            dispatchToSocket(socket, event);
        }
        catch (SocketException e)
        {
            System.err.println(e.toString());
            socket.close();
            throw e;
        }
        finally 
        {
            connector.releaseSocket(socket, endpoint);
        }
    }