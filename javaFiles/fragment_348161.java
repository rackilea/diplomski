String queryString = "SELECT ......"
ItemIterable<QueryResult> results = session.query(queryString, false);

for (QueryResult qResult : results) {
   String objectId = qResult.getPropertyValueByQueryName(objectIdQueryName);
   Document doc = (Document) session.getObject(session.createObjectId(objectId));
   List<String> paths = doc.getPaths();
   if (! paths.isEmpty()) {
      System.out.println(objectId + " lives at " + paths.get(0));
   }
 }