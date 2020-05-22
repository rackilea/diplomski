Set<String> address = new HashSet<String>();
  address.add("10.203.238.138");
  address.add("10.203.238.137");
  address.add("10.203.238.136");
  if(address!=null)
     QueryBuilder qb = QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery("address",address))
                .mustNot(QueryBuilders.termQuery("address", "10.203.238.140"))
                .should(QueryBuilders.termQuery("client", ""));
  else
     QueryBuilder qb = QueryBuilders.boolQuery()
                .mustNot(QueryBuilders.termQuery("address", "10.203.238.140"))
                .should(QueryBuilders.termQuery("client", ""));