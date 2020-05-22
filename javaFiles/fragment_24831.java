CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
Root<Person> p = criteria.from(Person.class);
criteria.select(p);


Expression<List<String>> emails = p.get(Person_.emails);
criteria.where(builder.isMember("[email address]", emails));


TypedQuery<Person> tq = entityManager.createQuery(criteria);
List<Person> persons = tq.getResultList();