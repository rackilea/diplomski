String sql = "SELECT x.last_access_date FROM records x ORDER BY x.last_access_date DESC";

//If you're not using calendar, change to your specific date class
TypedQuery<Calendar> query = em.createQuery(sql, Calendar.class);

Calendar lastDate = query.setFirstResult(499).setMaxResults(1).getSingleResult();

String delete = "DELETE FROM records x where x.last_access_date < :lastDate";
em.createQuery(delete).setParameter("lastDate", lastDate, TemporalType.DATE).executeUpdate();