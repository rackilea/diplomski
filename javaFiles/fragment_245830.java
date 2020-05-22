TypedQuery<Object[]> query = em.createQuery(
      "select distinct function('month',t.date) ,
       function('year',t.date) , field3 from YourEntity t", Object[].class);
  List<Object[]> results = query.getResultList();
  for (Object[] result : results) {
      System.out.println("month: " + result[0] + ", year: " + result[1]
      + ", field3:"+  result[2]);
  }