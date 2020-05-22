public List<Tripulante> listxxx(String tip,
    String uni, String est, boolean val) {
Query q = em.createQuery("select");
q.setHint("javax.persistence.cache.storeMode", "REFRESH");
q.setParameter(dat1, uni);
q.setParameter(dat2, est);
q.setParameter(dat3, val);
return q.getResultList();