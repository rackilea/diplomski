Map<Class<? extends Persistable>, Persistor> persistors = initializePersistors(); // even better some dependency injection here

...

public <T extends Persistable> PersistTypeEnum persist(T Item, Class<T> itemClass) {
    return persistors.get(itemClass).persist(item); // handle 'no such key' exception 
}