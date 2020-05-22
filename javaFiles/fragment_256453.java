Query q = new Query(
    new Criteria().andOperator(
        Criteria.where("_id").is(someId),
        Criteria.where("deleted").is("false")
    )
);