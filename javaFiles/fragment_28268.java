public class ExtendedQueryParser extends QueryParserBase<AbstractQueryDecorator> {

    private final DefaultQueryParser defaultQueryParser;

    public ExtendedQueryParser(MappingContext mappingContext) {
        super(mappingContext);
        defaultQueryParser = new DefaultQueryParser(mappingContext);
    }

    @Override
    public final SolrQuery doConstructSolrQuery(
            AbstractQueryDecorator query, Class<?> domainType) {
        ExtendedQuery decoratedQuery = (ExtendedQuery) query.getDecoratedQuery();

        SolrQuery solrQuery = 
            defaultQueryParser.constructSolrQuery(decoratedQuery, domainType);

        Optional.ofNullable(decoratedQuery.getDefaultField())
            .ifPresent(defaultField -> 
                solrQuery.setParam(CommonParams.DF, defaultField));
        if (!CollectionUtils.isEmpty(decoratedQuery.getQueryFields())) {
            solrQuery.setParam(DisMaxParams.QF, 
                String.join(SPACE, decoratedQuery.getQueryFields()));
        }

        return solrQuery;
    }
}