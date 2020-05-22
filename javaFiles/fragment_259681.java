List<T> findByCriteriaImpl(List<String> fetches, Criterion... criterion) {
       Criteria crit = createCriteria(getPersistentClass());
       if (criterion != null) {
          for (Criterion c : criterion) {
               crit.add(c);
          }
          for (String s : fetches) {
               crit.setFetchMode(s, FetchMode.JOIN);
          }
       }
       long startTime = System.currentTimeMillis();
       List<T> toReturn = crit.list();
       reportQueryTimeForMonitoring(System.currentTimeMillis() - startTime, "findByCriteriaImpl", "for criteria " + crit);
       return toReturn;
}