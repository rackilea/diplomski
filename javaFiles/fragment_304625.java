// Construct then prepare your query
List<Entity> get5TallestPeople() {
    DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
    Query q = new Query("Person");
    q.addSort("height", SortDirection.DESCENDING);
    PreparedQuery pq = ds.prepare(q);
    return pq.asList(FetchOptions.Builder.withLimit(5));
}