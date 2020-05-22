DetachedCriteria acceptedCatIds = DetachedCriteria.forClass(Cat.class);
acceptedCatIds.createAlias("kitten", "kitten")
              .add(Restrictions.like("kitten.name", "%kitten%" ))
              .setProjection(Projections.id());

Criteria acceptedCats = session.createCriteria(Cat.class)
acceptedCats.add(Subqueries.propertyIn("id", acceptedCatIds));