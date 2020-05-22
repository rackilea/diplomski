@Configuration
class MyLettuceConnectionFactory extends LettuceConnectionFactory {

    @Autowired
    public MyLettuceConnectionFactory(
            @Value("${redis-configuration.clusterEndpoint}") String clusterNodes,
            @Value("${redis-configuration.port}") int port,
            @Value("${redis-configuration.ssl}") boolean ssl,
            @Value("${redis-configuration.pool.minimumIdle}") int minIdle,
            @Value("${redis-configuration.pool.maximumIdle}") int maxIdle
            ) {
        super(new MyLettucePool(clusterNodes, port, ssl, minIdle, maxIdle));
        this.setUseSsl(ssl);
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        DirectFieldAccessor accessor = new DirectFieldAccessor(this);
        AbstractRedisClient client = (AbstractRedisClient) accessor.getPropertyValue("client");
        if(client instanceof RedisClusterClient){
            RedisClusterClient clusterClient = (RedisClusterClient) client;
            clusterClient.setOptions(ClusterClientOptions.builder().validateClusterNodeMembership(false).build());
        }
    }
}