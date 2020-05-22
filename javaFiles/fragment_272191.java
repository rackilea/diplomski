DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
Query q = new Query("Items");
PreparedQuery pq = ds.prepare(q);
for (Entity result : pq.asIterable()) {
    if (longDescription isinstanceof Text)
        Text longDescription = (Text)result.getProperty("longDescription");
    else
        log.severe("Unexpected datatype: longDescription is a "
            + result.getProperty("longDescription").getClass().toString());
}