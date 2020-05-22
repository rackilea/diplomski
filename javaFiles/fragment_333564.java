public class MyLettucePool implements LettucePool {

    private RedisClusterClient client;
    private int dbIndex=0;
    private GenericObjectPool<StatefulConnection<byte[], byte[]>> internalPool;


    public MyLettucePool(String clusterEndpoint, int port, boolean useSsl, int minIdle, int maxIdle) {
        RedisURI uri = new RedisURI();
        uri.setSsl(useSsl);
        uri.setPort(port);
        uri.setHost(clusterEndpoint);


        GenericObjectPoolConfig<StatefulConnection<byte[], byte[]>> config = new GenericObjectPoolConfig<>();
        config.setMinIdle(minIdle);
        config.setMaxIdle(maxIdle);

        this.client = RedisClusterClient.create(uri);
        this.client.setOptions(ClusterClientOptions.builder().autoReconnect(true).validateClusterNodeMembership(false).build());
        this.internalPool = ConnectionPoolSupport.createGenericObjectPool(() -> this.client.connect(new ByteArrayCodec()), new GenericObjectPoolConfig());
}


    @Override
    public AbstractRedisClient getClient() {
        return this.client;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StatefulConnection<byte[], byte[]> getResource() {
       try {
            return internalPool.borrowObject();
        } catch (Exception e) {
            throw new PoolException("Could not get a resource from the pool", e);
        }
    }

    @Override
    public void returnBrokenResource(final StatefulConnection<byte[], byte[]> resource) {

        try {
            internalPool.invalidateObject(resource);
        } catch (Exception e) {
            throw new PoolException("Could not invalidate the broken resource", e);
        }
    }


    @Override
    public void returnResource(final StatefulConnection<byte[], byte[]> resource) {
        try {
            internalPool.returnObject(resource);
        } catch (Exception e) {
            throw new PoolException("Could not return the resource to the pool", e);
        }
    }

    @Override
    public void destroy() {
        try {
            client.shutdown();
            internalPool.close();
        } catch (Exception e) {
            throw new PoolException("Could not destroy the pool", e);
        }
    }