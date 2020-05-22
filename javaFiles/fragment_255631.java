@Bean
LettuceConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {

    Cluster clusterProperties = redisProperties.getCluster();
    RedisClusterConfiguration config = new RedisClusterConfiguration(
            clusterProperties.getNodes());

    if (clusterProperties.getMaxRedirects() != null) {
        config.setMaxRedirects(clusterProperties.getMaxRedirects());
    }

    return new LettuceConnectionFactory(config);
}