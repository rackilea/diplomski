BlockStore blockStore = new MyCustomBlockStore(NETWORK_PARAMETERS);
blockStore.getChainHead();

blockChain = new BlockChain(NETWORK_PARAMETERS, blockStore);

PeerGroup peerGroup = new PeerGroup(NETWORK_PARAMETERS, blockChain);
peerGroup.setDownloadTxDependencies(1000);
peerGroup.setBloomFilteringEnabled(false);
peerGroup.addPeerDiscovery(new PeerDiscovery() {
    private final PeerDiscovery normalPeerDiscovery = new DnsDiscovery(NETWORK_PARAMETERS);

    @Override
    public InetSocketAddress[] getPeers(long services, long timeoutValue, TimeUnit timeoutUnit) throws PeerDiscoveryException {
        final List<InetSocketAddress> peers = new LinkedList<InetSocketAddress>();
            peers.addAll(Arrays.asList(normalPeerDiscovery.getPeers(services, timeoutValue, timeoutUnit)));
            InetSocketAddress[] isas = new InetSocketAddress[0];
            return peers.toArray(isas);
        }

    @Override
    public void shutdown() {
        normalPeerDiscovery.shutdown();
    }
});

peerGroup.startAsync();
peerGroup.startBlockChainDownload(new PeerDataEventListener() {
    public void onBlocksDownloaded(Peer peer, Block block, @Nullable FilteredBlock filteredBlock, int i) {

        List<Transaction> transactionsList = block.getTransactions();
        int transactions = transactionsList == null ? 0 : transactionsList.size();

        long height = peer.getBestHeight() - i;
        //If the block contains transactions, it is likely to be complete.
        Log.e(TAG, "Downloaded block " + height + " with " + transactions + " transactions");
        blockUpdate(block);
    }

    private void blockUpdate(Block fBlock) throws IOException {
        //TODO: Update blockchain database with the full block.
    }

    public void onChainDownloadStarted(Peer peer, int i) {
        Log.i(TAG, "Started to download chain on peer " + peer);
    }

    @Nullable
    public List<Message> getData(Peer peer, GetDataMessage getDataMessage) {
        //Log.i(TAG, "getData from " + peer);
        return null;
    }

    public Message onPreMessageReceived(Peer peer, Message message) {
        //Log.i(TAG, "onPreMessageReceived (" + message.getClass().getSimpleName() + ") from " + peer);
        return message;
    }
});