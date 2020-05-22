MongoDatabase mongoDatabase = mongoTemplate.getDb();
MongoCollection<Document> targetCollection
                    = mongoDatabase.getCollection(mongoTemplate.getCollectionName(Target.class));
Document query = new Document();
query.put("_id", parkTargetId);
query.put("spots._id", parkingSpotId);

targetCollection.find(query);