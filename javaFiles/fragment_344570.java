Criteria criteriaA = etSessionFactory().getCurrentSession().
            createCriteria(EntityClassA.class);
criteriaA.add(Restrictions.ilike("id", keywords, MatchMode.ANYWHERE));
criteriaA.add(Restrictions.ilike("name", keywords, MatchMode.ANYWHERE));
criteriaA.add(Restrictions.ilike("age", keywords, MatchMode.ANYWHERE));

Criteria criteriaB = etSessionFactory().getCurrentSession().
            createCriteria(EntityClassB.class);
criteriaB.add(Restrictions.ilike("smth", keywords, MatchMode.ANYWHERE));
criteriaB.add(Restrictions.ilike("rows", keywords, MatchMode.ANYWHERE));
criteriaB.add(Restrictions.ilike("here", keywords, MatchMode.ANYWHERE));