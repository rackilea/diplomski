CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Shop > cq = cb.createQuery(Shop.class);
Root<Shop > root = cq.from(Shop.class);
cq.select(root.get("id"), cb.avg(root.get("ratings")));
cq.where( cb.le(cb.avg(root.get("ratings"), 5);
cq.groupBy(c.get("id"));