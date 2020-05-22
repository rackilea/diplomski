// Retrieve system list from database
HashMap<Integer, AbstractSystem> systemDataMap = new HashMap<AbstractSystem>(
            systemService.getSystemDataMap());

// Retrieve system info from cloud API
List<SystemName> systemNames = cloudClass.getImages();
for (SystemName systemName : systemNames) {
    if (systemDataMap.containsKey(systemName.getId()) {
        System.out.println("This will be slow...");
    }
}