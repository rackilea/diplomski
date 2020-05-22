QueryBuilder queryBuidlerType = QueryBuilder.start("working").is(1);

DBObject or1 = QueryBuilder.start().or(QueryBuilder.start("user").exists(true).get(), QueryBuilder.start("parent").exists(true).get()).get();
DBObject or2 = QueryBuilder.start().or(QueryBuilder.start("car.id").is(mId).and("car.model").is("mModel").get(), QueryBuilder.start("car.matched.id").is(mId).and("car.matched.model").is("mModel").get()).get();

queryBuidlerType.and(or1, or2);

DBObject queryType = queryBuidlerType.get();