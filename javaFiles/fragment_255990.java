List<Object[]> lsMaxBatch = em.createNativeQuery(sqlMaxBatch).getResultList();
Iterator<Object[]> iter = lsMaxBatch.iterator();
while (iter.hasNext()) {
    Object[] row = iter.next();
    Short batchId = (Short) row[0];
    ls.add(batchId);
}