BulkOperations bulkOps = mongoTemplate.bulkOps(BulkMode.UNORDERED, Census.class);
for(Employee employee : employeeList) {
    Query query = new Query().addCriteria(new Criteria("id").is(id));
    Update update = new Update().set("employeeList.$", employee);
    bulkOps.updateOne(query, update);
}
BulkWriteResult results = bulkOps.execute();