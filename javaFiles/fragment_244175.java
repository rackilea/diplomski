Criteria criteria = getCurrentSession().createCriteria(A.class, "a");


    criteria.createAlias("a.listName1", "b", JoinType.LEFT_OUTER_JOIN);
    criteria.createAlias("b.listName2", "c", JoinType.LEFT_OUTER_JOIN);
    criteria.createAlias("c.listName3", "d", JoinType.LEFT_OUTER_JOIN);

    ProjectionList projections = Projections.projectionList();

    projections.add(Projections.distinct(Projections.property("a.column_of_a")));
    projections.add(Projections.property("b.column_of_b"));
    projections.add(Projections.property("c.column_of_c"));
    criteria.setProjection(projections);

    criteria.add(Restrictions.eq("a.column_of_a", someValue));
    criteria.add(Restrictions.eq("c.column_of_c", someValue));

    criteria.addOrder(Order.asc("a.column_of_a"));
    criteria.addOrder(Order.desc("b.column_of_b"));

    @SuppressWarnings("unchecked")
    List<Object[]> records = criteria.list();

    for(int i=0;i<3;i++)
    {
        Object record[] = records.get(i);
        Object value = record[1];
        System.out.println("value::"+value);
    }