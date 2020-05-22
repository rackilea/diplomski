UpdateOperations<First> ops;
Query<First> updateQuery = datastore.createQuery(First.class).field("_id").equal(new ObjectId("58609ed483ce6037ec33fc8c"));

Second second = new Second();
second.setTitleSecond("Developer");
ops = datastore.createUpdateOperations(First.class).disableValidation().removeAll("secondClass", second);
datastore.update(updateQuery, ops);