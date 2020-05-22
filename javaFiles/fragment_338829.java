class Person {
  private Long id;
  private String name;
  private Car car;
  // getters and setters
}

class Car {
  private Long id;
  private String color;
  // getters and setters
}

List<Person> getPeople() {
  ProjectionList projections = Projections.projectionList()
    .add(Projections.id().as("id"))
    .add(Projections.property("name").as("name"))
    .add(Projections.property("c.id").as("car.id"))
    .add(Projections.property("c.color").as("car.color"));

  Criteria criteria = getCurrentSession().createCriteria(Person.class)
    .createAlias("car", "c")
    .setProjection(projections)
    .setResultTransformer(new AliasToBeanNestedResultTransformer(Person.class));

  return (List<Person>) criteria.list();
}

// each car of Person will be populated