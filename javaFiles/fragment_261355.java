Query q = new Query("Person");
QueryResultList<Entity> results;
Cursor cursor = null;
FetchOptions queryOptions = FetchOptions.Builder.withChunkSize(500);

do {
    if (cursor != null) {
        queryOptions.startCursor(cursor);
    }
    results = datastore.prepare(q).asQueryResultList(queryOptions);

    for (Entity entity : results) {
        // do something
    }
    cursor = results.getCursor();

} while (results.size() == 500);