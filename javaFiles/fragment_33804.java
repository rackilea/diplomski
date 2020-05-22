try {
   dbCollection
       .withWriteConcern(WriteConcern.ACKNOWLEDGED)
       .insertOne(new BasicDBObject(someDoc));

   response.setSuccess(true);
} catch (MongoWriteConcernException x) {
   response.setSuccess(false);
}