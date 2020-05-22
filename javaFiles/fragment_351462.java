Query query = new Query("__BlobInfo__"); 
query.addFilter("filename", FilterOperator.EQUAL, filename); 
DatastoreService datastore = DatastoreServiceFactory.getDatastoreService(); 
PreparedQuery pq = datastore.prepare(query); 
List<Entity> entList = pq.asList(FetchOptions.Builder.withLimit(1)); 
String name = entList.get(0).getKey().getName();