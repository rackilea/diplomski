try {
    final StringBuilder qry = new StringBuilder();
    qry.append(" SELECT")
            .append(" FROM Price p")
            .append(" WHERE p.valueDate = (SELECT MAX(pr.valueDate) FROM Price pr)")
            .append(" AND p.fundId = :fundId");
    return getJpaTemplate().execute(new JpaCallback() {
        public Object doInJpa(EntityManager em)
                throws PersistenceException {
            Query q = em.createQuery(qry.toString());
            q.setParameter("fundId", fundId);
            return q.getResultList();
        }
    });
} catch (RuntimeException re) {}