/**
 * Gets a collection with a given name.
 *
 * @param name the name of the collection to return
 * @return the collection
 */
public DBCollection getCollection(final String name) {
    DBCollection collection = collectionCache.get(name);
    if (collection != null) {
        return collection;
    }