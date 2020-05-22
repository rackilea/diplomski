//some parameters to your method
    String param1 = "1";
    String paramNull = null;

    CriteriaBuilder qb = em.getCriteriaBuilder();
    CriteriaQuery cq = qb.createQuery();
    Root<A> customer = cq.from(A.class);

    //Constructing list of parameters
    List<Predicate> predicates = new ArrayList<Predicate>();

    //Adding predicates in case of parameter not being null
    if (param1 != null) {
        predicates.add(
                qb.equal(customer.get("someAttribute"), param1));
    }
    if (paramNull != null) {
        predicates.add(
                qb.equal(customer.get("someOtherAttribute"), paramNull));
    }
    //query itself
    cq.select(customer)
            .where(predicates.toArray(new Predicate[]{}));
    //execute query and do something with result
    em.createQuery(cq).getResultList();