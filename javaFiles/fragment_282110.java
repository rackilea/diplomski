Map<String, AttributeValue> newImage = record.getDynamodb().getNewImage(); 
List<Map<String, AttributeValue>> listOfMaps = new ArrayList<Map<String, AttributeValue>>(); 
listOfMaps.add(newImage); 
List<Item> itemList = InternalUtils.toItemList(listOfMaps); 
for (Item item : itemList) { 
  String json = item.toJSON(); 
  Metrics metric = objectMapper.readValue(json, Metrics.class); 
}