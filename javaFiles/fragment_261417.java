DetachedCriteria subquery = DetachedCriteria
            .forClass(Family.class, "family")
            .add(Expression.eq("family.id", family.getId()));

                subquery.createAlias("members", "members")
                    .add(Restrictions.eqProperty("members.id", "m.id"))
                    .add(Expression.eq("members.DOB",Date));

                subquery.setProjection(Property.forName("members.id"));

                Criteria crit = session.createCriteria(Member.class, "m")
                        .add(Subqueries.propertyIn("m.id", subquery));


            results = crit.list();