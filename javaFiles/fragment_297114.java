@Override
    public SolrResponse dataImport(final String command) {

      return solrTemplate.execute(new SolrCallback<SolrResponse>() {

        @Override
        public SolrResponse doInSolr(SolrServer solrServer) throws SolrServerException, IOException {
          return new SolrRequest(METHOD.GET, "/dataimport?command=" + command) {

            //..skipped some methods to shorten

            @Override
            public SolrResponse process(SolrServer server) throws SolrServerException, IOException {
              SolrResponseBase response = new SolrResponseBase();
              response.setResponse(server.request(this));
              return response;
            }

          }.process(solrServer);

        }
      });
    }