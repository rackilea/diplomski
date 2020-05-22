public List<Query> searchQueryByTag(Tag tag) throws QADAOException {
        javax.persistence.Query query = getEntityManager().createQuery(SQL_SEL_QUERY_TAG_ID);
        query.setParameter("tag", tag.getId());
        List<Query> queries = query.getResultList();
        return queries;

    }