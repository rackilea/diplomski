em = factory.createEntityManager();
  A a = em.find(A.class, id);
  em.close();//no longer needed
  println(a.getBList().size());
  a = addB(a, "value1");

  println(a.getBList().size());