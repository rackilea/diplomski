ProjectionList hostelProj = Projections.projectionList();
    String id = sessionFactory.getClassMetadata(Hostel.class)
            .getIdentifierPropertyName();
    hostelProperties.add(Projections.alias(Projections.property(id),id));
    for (String prop: sessionFactory.getClassMetadata(Hostel.class).getPropertyNames()) {
        hostelProperties.add(Projections.alias(Projections.property(prop), prop));
    }
    Criteria criteria = session.createCriteria(Hostel.class);
    criteria.createAlias("owner", "owner", JoinType.LEFT_OUTER_JOIN);
    criteria.setProjection(
            Projections.projectionList()
                    .add(hostelProj)
                    .add(Projections.property("owner.id"))
                    .add(Projections.property("owner.firstName"))
                    .add(Projections.property("owner.lastName")));
    List list = criteria.list();