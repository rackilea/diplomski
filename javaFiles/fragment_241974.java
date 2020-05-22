// Your Topic Resource
ConfigResource cr = new ConfigResource(Type.TOPIC, "mytopic");

// Create all your configurations
Collection<ConfigEntry> entries = new ArrayList<>();
entries.add(new ConfigEntry(TopicConfig.SEGMENT_BYTES_CONFIG, String.valueOf(segmentbytes)));
entries.add(new ConfigEntry(TopicConfig.RETENTION_BYTES_CONFIG, String.valueOf(retentionBytes)));
...

// Create the Map
Config config = new Config(entries);
Map<ConfigResource, Config> configs = new HashMap<>();
configs.put(cr, config);

// Call alterConfigs()
admin.alterConfigs(configs);