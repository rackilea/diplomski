EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
EntityManager em = emf.createEntityManager();

Session sess = em.unwrap(Session.class); // <-- Use Hibernate-specific features
SQLQuery query = sess.createSQLQuery(
   "SELECT AVG(age) AS averageAge, AVG(salary) as averageSalary FROM persons");

query.setResultTransformer(Transformers.aliasToBean(MyResult.class));
MyResult result = (MyResult) query.list().get(0);