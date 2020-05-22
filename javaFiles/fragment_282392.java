EntityManager em = ...
// fetch your B instances
List<B> bs = ...
em.close();
for (B b : bs)
  for (A a : b.as)
    // *BOOM*
    System.out.println(a);