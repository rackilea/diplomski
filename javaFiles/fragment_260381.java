List<String> fieldsSelectedByUser = ...;
 FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.
                        getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory()
                        .buildQueryBuilder().forEntity(Client.class).get();

        org.apache.lucene.search.Query query =
                queryBuilder
                        .keyword()
                        .wildcard()
                        .onFields(fieldsSelectedByUser.toArray(new String[0]))
                        .matching("*"+searchText.toLowerCase()+"*")
                        .createQuery();