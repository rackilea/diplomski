public class MyStateManager
{
    private final Channel channel;
    private AtomicBoolean messageSent = new AtomicBoolean(false);
    public MyStateManager(Channel channel)
    {
        this.channel = channel;
    }

    // Called by the ReadTimeoutCallback
    public void sendGenericResponse()
    {
        if (messageSent.getAndSet(true))
        {
           //... write generic response to channel
           ChannelFuture future = channel.write... 
           // Add listeners to future, etc
        } 
    }

    // Called by the RequestCompletedCallback
    public void sendResponse(MyResponseObject response)
    {
        if (messageSent.getAndSet(true))
        {
            // write returned response to channel
            ChannelFuture future = channel.write(response);
            // Add listeners to future, etc
        }
    }

}