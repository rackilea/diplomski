criteria.createAlias("owner", "owner", JoinType.LEFT_OUTER_JOIN)
    .setProjection(
            Projections.projectionList()
                    .add(Projections.property("hostelId"))
                    .add(Projections.property("country"))
                    .add(Projections.property("endDate"))
                    ...
                    ... all other properties from Hostel
                    ...
                    .add(Projections.property("owner.userId"))
                    .add(Projections.property("owner.firstName"))
                    .add(Projections.property("owner.lastName")));