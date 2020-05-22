Session session = sessionFactory.openSession();
Person person = session.get(Person.class, 1L);
session.close();

person.setName("Bob");

Session session2 = sessionFactory.openSession();
Transaction transaction2 = session2.beginTransaction();

person = (Person) session2.merge(person);
session2.flush();

System.out.println(person.getVersion()); // here version will be updated

transaction2.commit();
session2.close();