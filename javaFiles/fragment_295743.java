QueryBuilder builder = nestedQuery("car", boolQuery()
    .must(termQuery("car.name", "subaru"))
    .must(termQuery("car.model", "imprezza")));

SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
List<Person> persons = elasticsearchTemplate.queryForList(searchQuery, Person.class);