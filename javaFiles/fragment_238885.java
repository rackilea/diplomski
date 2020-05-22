public class DatagramClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final Logger log = Logger.getLogger(DatagramClientHandler.class.getName());
    //private final QuotesGUI gui = new QuotesGUI();
    private volatile Channel channel = null;
    private List<MessageListener> listeners;

    DatagramClientHandler() {
        listeners = new ArrayList<MessageListener>(25);
        //...
    }

    public synchronized void addMessageListener(MessageListener listener) {
        listeners.add(listener);
    }

    public synchronized void removeMessageListener(MessageListener listener) {
        listeners.remove(listener);
    }

    protected synchronized void fireQuoteRecieved(String quote) {
        for (MessageListener listener : listeners) {
            listener.quoteRecieved(this, quote);
        }
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String response = msg.content().toString(CharsetUtil.UTF_8);
        log.info(response);
        fireQuoteRecieved(response);
    }

    //...etc...