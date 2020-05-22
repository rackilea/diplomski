// First, fetch first 20 elements' ids
List<Integer> ids = session.createCriteria(Entity.class)
        .setProjection(Projections.property("id"))
        .setMaxResults(20)
        .list();

// Afterwards, do a sum on the desired field
Long sum = (Long) session.createCriteria(Entity.class)
        .setProjection(Projections.sum("propertyName"))
        .add(Restrictions.in("id", ids))
        .uniqueResult();