List<Criteria> criterias = new ArrayList<>();
for (String fieldName : fieldArray) {
    //Create the criterias like you want
    criterias.add(Criteria.where("data." + fieldName).is("some_constant"));
}

Query query = new Query(
    new Criteria().orOperator(
        criterias.toArray( //convert the list into an Criteria[] for the varargs parameter
            new Criteria[criterias.size()]
        )
    )
);