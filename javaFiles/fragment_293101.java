//You need to do this once on each JVM(Hazelcast node) at the begining  
Config myConfig = new Config();
Map<String, MapConfig> myHazelcastMapConfigs = myConfig.getMapMapConfigs();
MapConfig myMapConfig = new MapConfig();
myMapConfig.setName("myMapName");
myMapConfig.setTimeToLiveSeconds(1000);
myHazelcastMapConfigs.put("myMapName", myMapConfig);
Hazelcast.init(myConfig);