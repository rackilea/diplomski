public static int getEarliestValue(Map<DBObject, DBCursor> cursorMap, AtomicReference<DBObject> result) {
    int mergeCount = 1;
    if (!cursorMap.isEmpty()) {
        long ealiest = Long.MAX_VALUE;
        for (DBObject o : cursorMap.keySet()) {
            // do stuff to init tmp
            ...
            if (tmp < ealiest) {
                result.set(o);
                ealiest = tmp;
            }
        // other stuff .....
    }
    return mergeCount;
}

...
...

AtomicReference<DBObject> resultReference = new AtomicReference<>(null);
int mergeCount = MongoTickReaderUtil.getEarliestValue(cursorList, resultReference);
DBObject result = resultReference.get();