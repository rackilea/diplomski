public class DCORepositoryFactory extends CouchbaseRepositoryFactory {

CouchbaseOperations                                                                 couchbaseOperations;
MappingContext<? extends CouchbasePersistentEntity<?>, CouchbasePersistentProperty> mappingContext;

public DCORepositoryFactory(CouchbaseOperations couchbaseOperations) {
    super(couchbaseOperations);
    mappingContext = couchbaseOperations.getConverter().getMappingContext();
    this.couchbaseOperations = couchbaseOperations;
}

@Override
protected Object getTargetRepository(RepositoryMetadata metadata) {
    // TODO Auto-generated method stub
    CouchbaseEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
    final DCORepository simpleCouchbaseRepository = new DCORepository(entityInformation, couchbaseOperations);

    simpleCouchbaseRepository.setViewMetadataProvider(ViewPostProcessor.INSTANCE.getViewMetadataProvider());
    return simpleCouchbaseRepository;
}

@Override
protected QueryLookupStrategy getQueryLookupStrategy(QueryLookupStrategy.Key key) {
    return new CouchbaseQueryLookupStrategy();
}

/**
 * Currently, only views are supported. N1QL support to be added.
 */
private class CouchbaseQueryLookupStrategy implements QueryLookupStrategy {
    @Override
    public RepositoryQuery resolveQuery(Method method, RepositoryMetadata metadata, NamedQueries namedQueries) {
        CouchbaseQueryMethod queryMethod = new CouchbaseQueryMethod(method, metadata, mappingContext);
        return new PagingViewBasedCouchbaseQuery(queryMethod, couchbaseOperations);
    }
}

private static class PagingViewBasedCouchbaseQuery extends ViewBasedCouchbaseQuery {

    private static final org.slf4j.Logger   LOGGER  = org.slf4j.LoggerFactory
                                                            .getLogger(DCORepositoryFactory.PagingViewBasedCouchbaseQuery.class);

    private CouchbaseOperations             operations;
    private CouchbaseQueryMethod            method;

    public PagingViewBasedCouchbaseQuery(CouchbaseQueryMethod method, CouchbaseOperations operations) {
        super(method, operations);
        this.operations = operations;
        this.method = method;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.couchbase.repository.query.
     * ViewBasedCouchbaseQuery#execute(java.lang.Object[]) added the ability
     * to support paging
     */
    @Override
    public Object execute(Object[] runtimeParams) {
        Query query = null;
        Pageable pageable = null;
        for (Object param : runtimeParams) {
            if (param instanceof Query) {
                query = (Query) param;
            } else if (param instanceof Pageable) {
                pageable = (Pageable) param;
            } else {
                throw new IllegalStateException(
                        "Unknown query param: (btw null is also not allowed and pagable cannot be null) " + param);
            }
        }

        if (query == null) {
            query = new Query();
        }
        query.setReduce(false);
        if (pageable != null) {

            CouchbaseClient client = operations.getCouchbaseClient();
            View view = client.getView(designDocName(), viewName());

            // Paginator p = new Paginator(client, view, query,
            // pageable.getPageSize());
            Paginator paginator = client.paginatedQuery(view, query, pageable.getPageSize());
            // now we need to goto the start point
            ViewResponse viewResponse = null;
            // views are 0 base
            int i = 0;
            while (paginator.hasNext()) {
                viewResponse = paginator.next();
                if (pageable.getPageNumber() == i++) {
                    LOGGER.debug("Found the response for this page: {} ", i);
                    break;
                }
            }

            if (viewResponse == null) {
                LOGGER.debug("no view response so leaving now");
                return null;
            }
            Class<?> type = method.getEntityInformation().getJavaType();

            final List result = new ArrayList(viewResponse.size());
            for (final ViewRow row : viewResponse) {
                result.add(operations.findById(row.getId(), type));
            }
            return result;

        } else {
            return operations.findByView(designDocName(), viewName(), query, method.getEntityInformation()
                    .getJavaType());
        }
    }

    /**
     * Returns the best-guess design document name.
     *
     * @return the design document name.
     */
    private String designDocName() {
        if (method.hasViewAnnotation()) {
            return method.getViewAnnotation().designDocument();
        } else {
            return StringUtils.uncapitalize(method.getEntityInformation().getJavaType().getSimpleName());
        }
    }

    /**
     * Returns the best-guess view name.
     *
     * @return the view name.
     */
    private String viewName() {
        if (method.hasViewAnnotation()) {
            return method.getViewAnnotation().viewName();
        } else {
            return StringUtils.uncapitalize(method.getName().replaceFirst("find", ""));
        }
    }
}

@Override
protected Class<?> getRepositoryBaseClass(RepositoryMetadata repositoryMetadata) {
    return DCORepository.class;
}

}