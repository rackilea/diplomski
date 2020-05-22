SumBuilder sumGrades = AggregationBuilders.sum("sum_grade").field("grade");

ReverseNestedBuilder backToGrades = AggregationBuilders.reverseNested("spring_to_grade")
    .subAggregation(sumGrades);

TermsBuilder bySprint = AggregationBuilders.terms("by_sprint")
    .field("sprint.sprintname").subAggregation(backToGrades)

NestedBuilder nested = AggregationBuilders.nested("nested").path("sprint")
    .subAggregation(bySprint);

String names[] = { "changed", "jira" };
QueryBuilder query = QueryBuilders.boolQuery().must(
QueryBuilders.nestedQuery("sprint",QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("sprint.sprintname", names))));
FilterAggregationBuilder aggregation = AggregationBuilders.filter("agg").filter(query).subAggregation(nested);