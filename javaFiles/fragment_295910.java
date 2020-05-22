final CriteriaQuery<Cat> cq = getCriteriaBuilder().createQuery(Cat.class);
final CriteriaBuilder cb = entityManager.getCriteriaBuilder();

final Root<Usercat> uc= cq.from(Usercat.class);

cq.select(uc.get("cat");

Predicate p = cb.equal(uc.get("favourtie", true);
p = cb.and(p, cb.equal(uc.get("user"), user));
cq.where(p);

final TypedQuery<Cat> typedQuery = entityManager.createQuery(cq);
return typedQuery.getResultList();