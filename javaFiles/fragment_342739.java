TypedQuery<Object[]> q = getEntityManager().createQuery(
    "SELECT c.id, count(p.id) " +
    "FROM Product p LEFT JOIN p.category c " +
    "WHERE p.seller.id = :id " +
    "GROUP BY c.id", Object[].class).setParameter("id", id);

List<Object[]> resultList = q.getResultList();
Map<String, Long> resultMap = new HashMap<String, Long>(resultList.size());
for (Object[] result : resultList)
  resultMap.put((String)result[0], (Long)result[1]);