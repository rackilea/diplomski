// Channel queries

// We can only send channel queries to peers that are in the same org as the SDK user context
// Get the peers from the current org being used and pick one randomly to send the queries to.
Set<Peer> peerSet = sampleOrg.getPeers();
//  Peer queryPeer = peerSet.iterator().next();
//   out("Using peer %s for channel queries", queryPeer.getName());

BlockchainInfo channelInfo = channel.queryBlockchainInfo();
out("Channel info for : " + channelName);
out("Channel height: " + channelInfo.getHeight());
String chainCurrentHash = Hex.encodeHexString(channelInfo.getCurrentBlockHash());
String chainPreviousHash = Hex.encodeHexString(channelInfo.getPreviousBlockHash());
out("Chain current block hash: " + chainCurrentHash);
out("Chainl previous block hash: " + chainPreviousHash);

// Query by block number. Should return latest block, i.e. block number 2
BlockInfo returnedBlock = channel.queryBlockByNumber(channelInfo.getHeight() - 1);
String previousHash = Hex.encodeHexString(returnedBlock.getPreviousHash());
out("queryBlockByNumber returned correct block with blockNumber " + returnedBlock.getBlockNumber()
        + " \n previous_hash " + previousHash);
assertEquals(channelInfo.getHeight() - 1, returnedBlock.getBlockNumber());
assertEquals(chainPreviousHash, previousHash);

// Query by block hash. Using latest block's previous hash so should return block number 1
byte[] hashQuery = returnedBlock.getPreviousHash();
returnedBlock = channel.queryBlockByHash(hashQuery);
out("queryBlockByHash returned block with blockNumber " + returnedBlock.getBlockNumber());
assertEquals(channelInfo.getHeight() - 2, returnedBlock.getBlockNumber());

// Query block by TxID. Since it's the last TxID, should be block 2
returnedBlock = channel.queryBlockByTransactionID(testTxID);
out("queryBlockByTxID returned block with blockNumber " + returnedBlock.getBlockNumber());
assertEquals(channelInfo.getHeight() - 1, returnedBlock.getBlockNumber());

// query transaction by ID
TransactionInfo txInfo = channel.queryTransactionByID(testTxID);
out("QueryTransactionByID returned TransactionInfo: txID " + txInfo.getTransactionID()
        + "\n     validation code " + txInfo.getValidationCode().getNumber());