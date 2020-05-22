CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Entity> cq = cb.createQuery(Entity.class);
    Root<Entity> r = cq.from(Entity.class);

    List<Predicate> p = new ArrayList<>();

    //conditionally create zero or more conditions
    Predicate condition= cb.equal(r.get("fieldName"), user.getId());
    p.add(condition);

    if(Collections.isNotEmpty(p)){
         Predicate[] pArray = p.toArray(new Predicate[]{});
         Predicate predicate = cb.and(pArray);
         cq.where(predicate);
    }
    cq.orderBy(cb.desc(r.get("fieldName")));

    return em.createQuery(cq).getResultList();