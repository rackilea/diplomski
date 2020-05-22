SolrQuery query = new SolrQuery();   
String nested = "";
nested += "category_name:";
nested += categoryNames.get(0);
nested += " AND _query_:\"{!dismax qf=category_name v=";
nested += categoryNames.get(1);
nested += "}\"";
query.setQuery(nested);
QueryResponse response = solr.query(query);