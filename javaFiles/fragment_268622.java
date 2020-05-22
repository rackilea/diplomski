@Autowired
  MongoTemplate mongoTemplate;

  List<Entities> findThingsbyInputs(Long initialDate, Long endDate, Integer input2,
                                    List<Integer> input1, Integer input3) {
    Query query = new Query();
    if(initialDate != null) {
      query.addCriteria(where("input1").is(input1));
    }

    query.addCriteria(where("input2").is(input2));
    query.addCriteria(where("input3").is(input3));
    query.addCriteria(new Criteria().andOperator(where("dateInput").gt(initialDate),
        where("dateInput").lt(endDate)));

    return mongoTemplate.find(query, Entities.class);

  }