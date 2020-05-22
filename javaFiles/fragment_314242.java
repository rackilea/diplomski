@Bean
public HealthIndicator solrHealthIndicator() {
    Map<String, HealthIndicator> solrIndicators;
    solrIndicators.put("solr1", createHealthIndicator(firstHttpSolrClient()));
    solrIndicators.put("solr2", createHealthIndicator(secondHttpSolrClient()));
    solrIndicators.put("querySolr", createHealthIndicator(queryHttpSolrClient()));
    return CompositeHealthContributor.fromMap(solrIndicators);
}