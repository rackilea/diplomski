EntityManager em = ...
String sql = "SELECT b FROM B b JOIN b.as a WHERE a.id = :id";
TypedQuery<B> tq = em.createQuery(sql, B.class);
tq.setParameter("id", 100);
for (B b : tq.getResultList())
  System.out.println(b);