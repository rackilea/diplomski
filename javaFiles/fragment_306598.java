SimpleQuery query = new SimpleQuery(conditions);
    query.addProjectionOnField("*");
    query.addProjectionOnField("distance:geodist()");

    DefaultQueryParser qp = new DefaultQueryParser();
    final SolrQuery solrQuery = qp.constructSolrQuery(query);
    solrQuery.add("sfield", "store");
    solrQuery.add("pt", GeoConverters.GeoLocationToStringConverter.INSTANCE.convert(new GeoLocation(45.15, -93.85)));
    solrQuery.add("d", GeoConverters.DistanceToStringConverter.INSTANCE.convert(new Distance(5)));

    List<EventDocument> result = template.execute(new SolrCallback<List<EventDocument>>() {

      @Override
      public List<EventDocument> doInSolr(SolrServer solrServer) throws SolrServerException, IOException {
        return template.getConverter().read(solrServer.query(solrQuery).getResults(), EventDocument.class);
      }
    });