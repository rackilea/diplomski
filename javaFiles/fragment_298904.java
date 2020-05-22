Criteria c = session.createCriteria(Person.class, "person");
c.add(Restrictions.eq("age", 32));
DetachedCriteria dc = DetachedCriteria.forClass(Pet.class, "pet");
dc.add(Property.forName("pet.person_id").eqProperty("person.id"));
c.add(Subqueries.exists(dc.setProjection(Projections.id())));
List<Person> persons = c.list();