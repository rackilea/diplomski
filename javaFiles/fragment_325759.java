RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
  .master("mymaster")
  .sentinel("127.0.0.1", 26379)
  .sentinel("127.0.0.1", 26380);

JedisConnectionFactory factory = new JedisConnectionFactory(sentinelConfig);
factory.afterPropertiesSet();