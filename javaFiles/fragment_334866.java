CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
CriteriaQuery<Tuple> query= criteriaBuilder.createTupleQuery();

Root<Cargo> cargo= query.from(Cargo.class);
Root<Currency> currency= query.from(Currency.class);

query.multiselect(cargo.get("id"), currency.get("name"));
Query query = em.createQuery(cq);
List<Tuple> results = query.getResultList();