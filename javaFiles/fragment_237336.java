Map<ID, Entity> map = new HashMap<ID, Entity>(inputList.size());
for (Entity e : inputList) {
    Entity existing = map.get(e.getID());
    if (existing == null) {
        //not in map, add it
        map.put(e.getID(), e);
    } 
    else {
        existing.merge(e);
    }
}