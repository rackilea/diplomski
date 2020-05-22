Query query = new Query();
query.addCriteria(
    new Criteria().andOperator(
        Criteria.where("field1").exists(true),
        Criteria.where("field1").ne(false)
    )
);

List<Foo> result = mongoTemplate.find(query, Foo.class);
System.out.println("query - " + query.toString());

for (Foo foo : result) {
    System.out.println("result - " + foo);
}