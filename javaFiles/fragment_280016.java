public static void main(String [] args) {

    String bootStrapUrl = "tcp://localhost:6666";
    String storeName = "test";

    int maxThreads = 300;
    ClientConfig clientConfig = new ClientConfig();
    clientConfig.setMaxThreads(maxThreads);
    clientConfig.setMaxConnectionsPerNode(maxThreads);
    clientConfig.setConnectionTimeout(500, TimeUnit.MILLISECONDS);
    clientConfig.setBootstrapUrls(bootStrapUrl);

    StoreClientFactory factory = new SocketStoreClientFactory(clientConfig);
    StoreClient<String, String> client = factory.getStoreClient(storeName);

    int nodeId = 0;
    List<Integer> partitionList = new ArrayList<Integer>();
    partitionList.add(0);
    partitionList.add(1);
    AdminClient adminClient = new AdminClient(bootStrapUrl, new AdminClientConfig());
    Iterator<ByteArray> iterator = adminClient.fetchKeys(nodeId, storeName, partitionList, null);

    String key = null;
    String value = null;
    while (iterator.hasNext()) {
        key = new String(iterator.next().get());
        value = client.getValue(key);
        System.out.println("Key-Value-Pair::" + key + ":" + value);
    }

}