Map<Long, Entity> entitiesMap = ...
// get all ids
Collection<Long> addIds = entitiesMap.keySet();

// look up entities by id.
List<Long> ids = ...
List<Entity> matching = new ArrayList<>();
for(Long id: ids)
    matching.add(entitiesMap.get(id));