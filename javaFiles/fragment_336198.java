public List<Training> querySearch(String queryString) {
    FullTextEntityManager fullTextEm = Search.getFullTextEntityManager(this.entityManager);

    QueryDescriptor query = ElasticsearchQueries.fromQueryString(queryString);

    javax.persistence.Query persistenceQuery = fullTextEm.createFullTextQuery(query, Training.class);

    return persistenceQuery.getResultList();
}