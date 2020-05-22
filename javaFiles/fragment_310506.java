EntityManager em = ...;

FullTextEntityManager fullTextEntityManager =
    org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
    .buildQueryBuilder().forEntity( Etude.class ).get();

Query luceneQuery = queryBuilder.keyword()
    .onField("avisDefinitifCet").andField("clasCet1ErPassage")
    .matching("acceptation")
    .createQuery();