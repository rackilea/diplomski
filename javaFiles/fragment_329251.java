Entity oldEntity = c.element();

// We need to get the property map, but the one from DatastoreHelper is an unmodifiableMap
Map<String, Value> oldEntity_map = DatastoreHelper.getPropertyMap(oldEntity);
Map<String, Value> newEntity_map = new HashMap<String, Value>();
newEntity_map.putAll(oldEntity_map);

// Adding or updating a property
newEntity_map.put("newProperty", DatastoreHelper.makeValue("Value").build());
// Deleting a property
newEntity_map.remove("delete-this");

Entity.Builder updatedEntity = Entity.newBuilder(oldEntity);
updatedEntity.clear();
updatedEntity.setKey(oldEntity.getKey());

for (Map.Entry<String, Value> property : newEntity_map.entrySet())
{
    updatedEntity.addProperty(
       DatastoreHelper.makeProperty(property.getKey(), property.getValue()));
}

c.output(updatedEntity.build());