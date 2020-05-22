Iterator<Map.Entry<Integer, Entity>> iter = newEntities.entrySet().iterator();
while (iter.hasNext()) { 
    Map.Entry<Integer, Entity> entry = iter.next();
    entities.put(entities.size(), entry.getValue());
    iter.remove();
}