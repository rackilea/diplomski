QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Student.class).get();
    org.apache.lucene.search.Query query = qb.bool().must( qb.keyword().onFields("name","country","skills.skill").matching(keyword).createQuery())
            .must( qb.keyword().onField("skills.skill").matching(skill).createQuery())
            .must( qb.keyword().onField("locations.city").matching(location).createQuery())
            .must( qb.keyword().onField("jobStatus").matching("active").createQuery())
            .must( qb.keyword().onField("postedOrSaved").matching("posted").createQuery())
            .createQuery();
    org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Jobs.class);
    List<Jobs> result = hibQuery.list();