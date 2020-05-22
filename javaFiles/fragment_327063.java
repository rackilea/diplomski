CriteriaBuilder qb = em.getCriteriaBuilder();
CriteriaQuery<Store> cq = qb.createQuery(Store.class);

Root<Store> root = cq.from(Store.class);
root.fetch(App_.storeServers, JoinType.LEFT);

cq.select(root);

return em.createQuery(cq).getResultList();