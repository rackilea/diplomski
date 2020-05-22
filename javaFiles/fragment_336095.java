try {

 String query = "INSERT { _from:TurmaA._teste2, _to:TurmaA._testepedro } IN @@edges";
 Map<String, Object> bindVars = new MapBuilder().put("@edges", nome2).get();
 ArangoCursor<BaseDocument> cursor = arangoDB.db(dbName).query(query, bindVars, 
null, BaseDocument.class);

cursor.forEachRemaining(aDocument -> {
  System.out.println("Key: " + aDocument.getKey());
 });
} catch (ArangoDBException e) {
 System.err.println("Failed to execute query. " + e.getMessage());
}