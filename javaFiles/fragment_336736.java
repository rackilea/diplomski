public class MyService
{
    @Inject
    private BayeuxServer bayeuxServer;
    @Session
    private LocalSession sender;
    private final String _channelName;
    private ServerChannel _channel;

    public MyService() 
    {
        _channelName = "/cometd/";
    }

    @PostConstruct
    private void initChannel() 
    {
        _channel = bayeuxServer.createChannelIfAbsent(_channelName).getReference();
    }
}