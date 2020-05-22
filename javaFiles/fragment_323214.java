Map configMap = new HashMap();
configMap.put("akka.remote.netty.hostname", custom.ip);
configMap.put("akka.remote.netty.port", custom.port);

Config config = ConfigFactory.parseMap(configMap).withFallback(ConfigFactory.load());
ActorSystem system = ActorSystem.create("ActorSystem", config);