public class Reactor implements Runnable{

    Selector selector = Selector.open();

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    public Reactor(int port) throws IOException {

        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        serverSocketChannel.configureBlocking(false);

        // let Reactor handle new connection events
        registerAcceptor();

    }

    /**
     * Registers Acceptor as handler for new client connections.
     * 
     * @throws ClosedChannelException
     */
    private void registerAcceptor() throws ClosedChannelException {


        SelectionKey selectionKey0 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        selectionKey0.attach(new Acceptor());
    }

    @Override
    public void run(){

        while(!Thread.interrupted()){

            startReactorLoop();

        }

    }

    private void startReactorLoop() {

        try {

            // wait for new events for each registered or new clients
            selector.select();

            // get selection keys for pending events
            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> selectedKeysIterator = selectedKeys.iterator();

            while (selectedKeysIterator.hasNext()) {

                // dispatch even to handler for the given key
                dispatch(selectedKeysIterator.next());

                // remove dispatched key from the collection
                selectedKeysIterator.remove();
            }

        } catch (IOException e) {
            // TODO add handling of this exception
            e.printStackTrace();
        }
    }

    private void dispatch(SelectionKey interestedEvent) {

        if (interestedEvent.attachment() != null) {

            EventHandler handler = (EventHandler) interestedEvent.attachment();

            handler.processEvent();
        }

    }

    private class Acceptor implements EventHandler {

        @Override
        public void processEvent() {

            try {

                SocketChannel clientConnection = serverSocketChannel.accept();

                if (clientConnection != null) {

                    registerChannel(clientConnection);

                }

            } catch (IOException e) {e.printStackTrace();}

        }
    /**
     *  Save Channel - key association - in Map perhaps.
     * This is required for subsequent/partial reads/writes
     */
    private void registerChannel(SocketChannel clientChannel) {


        // notify injection mechanism of new connection (so it can activate Read Handler)
}