Query query = Query.parse(searchQuery, conf);
QueryParams queryParams = new QueryParams();
queryParams.setMaxHitsPerDup(100);
queryParams.setNumHits(100);
query.setParams(queryParams);
Hits hits = bean.search(query);
long allResultsCount =**hits.getTotal());**