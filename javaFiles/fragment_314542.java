List<IndexInfo> indexInfo = mongoTemplate.indexOps(TestModel.class).getIndexInfo();

mongoTemplate.dropCollection(TestModel.class);


indexInfo.forEach(index -> {
  DBObject indexOptions = new BasicDBObject();

  if(! index.getName().equals("_id_"))
  {
    indexOptions.put(index.getName(), 1);
    CompoundIndexDefinition indexDefinition = new CompoundIndexDefinition(indexOptions);
    indexDefinition.named(index.getName());
    mongoTemplate.indexOps(TestModel.class).ensureIndex(indexDefinition);
  }
});