CriteriaBuilder qb = em.getCriteriaBuilder();
    CriteriaQuery<Submission> cq = qb.createQuery(Submission.class);

    Root<Submission> root = cq.from(Submission.class);
    cq.where( qb.or( 
        qb.equal(root.get("code"), qb.parameter(String.class, "code")),
        qb.equal(root.get("id"), qb.parameter(Integer.class, "id"))
    ));
    Query query = em.createQuery(cq);