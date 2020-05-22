Builder builder = Cluster.builder()
  .addContactPoints(nodes)
  .withQueryOptions(new QueryOptions()
    .setConsistencyLevel(ConsistencyLevel.LOCAL_ONE))
  .withLoadBalancingPolicy(new TokenAwarePolicy(
    new DCAwareRoundRobinPolicy.Builder()
      .withLocalDc("DC1").build()))
  .withPoolingOptions(options);