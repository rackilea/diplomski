EntityManager em = getEntityManager();
EntityTransaction transaction = em.getTransaction();
transaction.begin();

Person person = new Person();
person.setAge(25);
person.setName("John Ive");
em.persist(person);

person.setAge(27);
em.merge(person);

transaction.commit();