String sql = "SELECT x.id FROM records x ORDER BY x.last_access_date DESC";
TypedQuery<Long> query = em.createQuery(sql, Long.class);

List<Long> ids = query.setMaxResults(500).getResultList();

String delete = "DELETE FROM records x where x.id not in :ids";
em.createQuery(delete).setParameter("ids", ids).executeUpdate();