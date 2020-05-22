@Bean
public ExtendedQueryParser extendedQueryParser(SolrTemplate solrTemplate) {
    ExtendedQueryParser extendedQueryParser = new ExtendedQueryParser(null);
    solrTemplate.registerQueryParser(ExtendedQuery.class, extendedQueryParser);
    return extendedQueryParser;
}