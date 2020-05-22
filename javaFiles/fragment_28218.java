criteria.add(Restrictions.le("date", to));
criteria.add(Restrictions.ge("date", from));    
criteria.setFirstResult(offset);
criteria.setMaxResults(count);
criteria.addOrder(Order.asc("funRounds"));
ProjectionList projections = Projections.projectionList().
                add(Projections.groupProperty("funRounds"));
criteria.setProjection(projections);
addSumProjections(projections);