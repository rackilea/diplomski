Criteria criteria = new Criteria();
criteria.where("dataset").is("d1");
Query query = new Query();
query.addCriteria(criteria);
List list = mongoTemplate.getCollection("collectionName")
    .distinct("source",query.getQueryObject());