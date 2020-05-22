FunctionScoreQueryBuilder fsqb = new FunctionScoreQueryBuilder(QueryBuilders.matchAllQuery());
fsqb.add(ScoreFunctionBuilders.randomFunction((new Date()).getTime()));
SearchRequestBuilder srb = getSafeClient()
 .prepareSearch("myindex")
 .setTypes("mytype")
 .setQuery(fsqb);