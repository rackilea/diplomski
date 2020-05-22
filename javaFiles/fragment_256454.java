Query q = new Query();
q.addCriteria(
    Criteria.where("age").exists(true).andOperator(
        Criteria.where("age").gt(10),
        Criteria.where("age").lt(40)
    )
);