Config config = new Config();
config.getNetworkConfig().setPort(5701);
config.getProperties().setProperty("hazelcast.discovery.enabled", "true");
JoinConfig joinConfig = config.getNetworkConfig().getJoin();
joinConfig.getMulticastConfig().setEnabled(false);

HazelcastKubernetesDiscoveryStrategyFactory discoveryStrategyFactory = new HazelcastKubernetesDiscoveryStrategyFactory();
Map<String, Comparable> properties = new HashMap<>();
joinConfig.getDiscoveryConfig().addDiscoveryStrategyConfig(new DiscoveryStrategyConfig(discoveryStrategyFactory, properties));