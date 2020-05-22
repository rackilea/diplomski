class xHandler
{
    private final Channel _channel;

    public xHandler(Channel channel)
    {
        this._channel = channel  
    }

    // Methods...

    void init()
    {           
        synchronized (_channel)
        {
            // Do some stuff here...e.g.
            _channel.send("...");
        }
    }

            public static void main(String[] args) 
            {
                Channel myChannel = new Channel(...);
                xHandler xHand1 = new xHandler(myChannel);
                xHandler xHand2 = new xHandler(myChannel);
                // Code to create / start your threads. 
                // xHand1 and xHand2 will not use myChannel simultaneously  
            }

}