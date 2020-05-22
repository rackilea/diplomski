public class ClientHandler extends SimpleChannelInboundHandler<Object>{

    private final Consumer<String> statusUpdate ;

    public ClientHandler(Consumer<String> statusUpdate) {
        this.statusUpdate = statusUpdate ;
    }

    /**Change the Status when the Client become connected to Server**/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(TAG + "Successfully Connected to Server.);

        statusUpdate.accept("Connected"); /**Post here**/
    }
}