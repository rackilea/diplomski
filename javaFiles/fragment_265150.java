Criteria criteria = session.createCriteria(Dog.class, "dog")
 .createAlias("owner", "own")
 .setProjection( Projections.projectionList()
   .add(Projections.property("dog.description"))
   .add(Projections.property("dog.weight"))
   .add(Projections.property("own.name"))
 );