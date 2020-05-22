Query queryCount = em.createQuery("SELECT COUNT(u) FROM UserTable u");
Long size = (Long) queryCount.getSingleResult();

//I use this way of Java8, you can use the way you see it better to generate random indexes
int[] index = new Random().ints(0, size, 10).toArray();

Query query = em.createQuery("SELECT u FROM UserTable u WHERE INDEX(u) IN :indexs");
                                                              ^^^^^^^^^^^^^^^^^^^
query.setParameter("indexs", index);
List<UserTable> listUsersRandom = query.getResultList();