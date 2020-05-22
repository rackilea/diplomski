furnitureList = new ArrayList<String>();
for(Map.Entry<String, List<String>> entry : furnitureMap.entrySet()) {
    if(entry.getKey() != null && entry.getKey().equalsIgnoreCase("FURNITURE_NAMES")) {
        furnitureList.addAll(entry.getValue());
    }
}