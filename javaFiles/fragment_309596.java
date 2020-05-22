Query q = em.createNativeQuery(queryStr);
List<Object[]> resultList = q.getResultList();

for (Object[] result : resultList) {
   entityObj.setReason(result[0].toString);
//rest attribute will convert from result[1].toString to corresponding
// data type and set to entity object
}