List<BeitragVO> results;

    List<String> fields= new ArrayList<String>();

    FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
            .getFullTextEntityManager(em); // em = entitymanager



    QueryBuilder qb = fullTextEntityManager.getSearchFactory()
            .buildQueryBuilder().forEntity(BeitragVO.class).get();

    if (student) {
        fields.add("user.surname");
        fields.add("user.givenname");
    }
    if (company) {
        fields.add("company.name");
    }


    org.apache.lucene.search.Query luceneQuery = qb.keyword()
            .onFields(fields.toArray(new String[fields.size()]))
            .matching(searchterm).createQuery();