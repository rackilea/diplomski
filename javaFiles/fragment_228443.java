//get the projection    
Criteria criteria = factory.getCurrentSession().createCriteria(getEntityClass());
    criteria.setProjection(Projections.distinct((Projections.projectionList().add(Projections.id()).add(Projections.property("name")))));
//paginate the results
    criteria.setMaxResults(pageSize);
    criteria.setFirstResult(first);

List<Object[]> idList = criteria.list();
//get the id's from the projection
        List<Long> longList = new ArrayList<Long>();
        for (Object[] long1 : idList) {
            Object[] record = long1;
            longList.add((Long) record[0]);
        }

if (longList.size() > 0) {
//get all the id's corresponding to the projection, 
//then apply distinct root entity
            criteria = factory.getCurrentSession().createCriteria(getEntityClass());
            criteria.add(Restrictions.in("id", longList));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        } else {
//no results, so let's ommit the second query to the DB
            return new ArrayList<E>();
        }

return criteria.list();