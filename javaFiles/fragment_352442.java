private void startListening()
{
    if (!isConnected)
    {
        closeIfNotNull();
        listener = createListeningSocket();
        es.execute( new ServAccept( listener, event -> setAccepted( event.getSocket() ) ) );
    }
}

private void setAccepted( Socket socket )
{
    if (!isConnected)
    {
        this.activeConenctionSocket = socket;
        setUpStreams( socket );
    } else
    {
        sendError( socket );
    }
}