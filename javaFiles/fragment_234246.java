@Bean (name = "SolrTemplateMap")
  public Map<Language, SolrTemplate> solrTemplateList(){
      HashMap<Language, SolrTemplate> map = new HashMap<>();
      for (Language l : Language.values()){
          SolrTemplate template = new SolrTemplate (configureHttpSolrServer(l));
          map.put( l, template);
      }
      return map;
  }

private SolrServer configureHttpSolrServer(String baseURL) {
        HttpSolrServerFactoryBean factoryBean = new HttpSolrServerFactoryBean();
        factoryBean.setUrl(baseURL);
        factoryBean.setMaxConnections(100);
        return factoryBean;
}