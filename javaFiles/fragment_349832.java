public List<T> findRangeByUser(int[] range, User user) {
    javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
    javax.persistence.criteria.Root<T> rt = cq.from(entityClass);     
    cq.where(cb.equal(rt.get("useridUser"), user));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0]);
    q.setFirstResult(range[0]);
    return q.getResultList();
}