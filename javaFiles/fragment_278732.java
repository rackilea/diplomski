Config config = new Config();
config.getNetworkConfig().setPort(5702);
config.getProperties().setProperty("hazelcast.discovery.enabled", "true");
JoinConfig joinConfig = config.getNetworkConfig().getJoin();
joinConfig.getMulticastConfig().setEnabled(false);

HazelcastKubernetesDiscoveryStrategyFactory discoveryStrategyFactory = new HazelcastKubernetesDiscoveryStrategyFactory();
Map<String, Comparable> properties = new HashMap<>();
String serviceName = System.getenv("KUBERNETES_SERVICE_NAME");
properties.put("service-name", serviceName);
properties.put("service-port", "5702");
joinConfig.getDiscoveryConfig().addDiscoveryStrategyConfig(new DiscoveryStrategyConfig(discoveryStrategyFactory, properties));

GroupConfig groupConfig = new GroupConfig("separate");