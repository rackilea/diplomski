Document query = new Document("id", 2);

Document setOnInsert = new Document();
setOnInsert.put("date", new Date());
setOnInsert.put("reptype", "EOD");
Document update = new Document("$setOnInsert", setOnInsert);

FindOneAndUpdateOptions options = new FindOneAndUpdateOptions();
options.returnDocument(ReturnDocument.AFTER);
options.upsert(true);

db.getCollection("COL1").findOneAndUpdate(query, update, options);