public class ClientHandler extends SimpleChannelInboundHandler<Object>{

    private final EventBus eventBus;

    public ClientHandler(EventBus eventBus){
        this.eventBus = eventBus;
    }

    /**Change the Status when the Client become connected to Server**/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(TAG + "Successfully Connected to Server.);

        eventBus.post("Connected"); /**Post here**/
    }
}