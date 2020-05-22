Set<String> mustNot = new HashSet<String>();
mustNot.add("child");
mustNot.add("children");
mustNot.add("childrens health");

Set<String> must = new HashSet<String>();
must.add("fever");
must.add("cough");

MatchQueryBuilder query = QueryBuilders.matchQuery("question", "Hello Dr. Iam suffering from fever with cough nd cold since 3 days");

BoolFilterBuilder filter = FilterBuilders.boolFilter()
    .must(FilterBuilders.termsFilter("topics", must))
    .mustNot(FilterBuilders.termsFilter("topics", mustNot));

FilteredQueryBuilder fqb = QueryBuilders.filteredQuery(query, filter);

FunctionScoreQueryBuilder fsqb = QueryBuilders.functionScoreQuery(fqb);
fsqb.add(ScoreFunctionBuilders.randomFunction((new Date()).getTime()));

SearchResponse response1 = client.prepareSearch("stopdata")
        .setQuery(fsqb)
        .execute()
        .actionGet();

System.out.println(response1.getHits().getTotalHits());