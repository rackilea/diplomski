List<Object[]> resultList = (List<Object[]>) query.getResultList();
for (Object[] array : resultList) {
   for (Object field : array) {
      System.out.println("->"+field); 
   }
}