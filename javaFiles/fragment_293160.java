CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
    Root<Org> orgRoot = cq.from(Org.class);
    Join<Org, Dept> ord = orgRoot.join("dept");
    cq.multiselect(orgRoot.get("orgname"), ord.get("deptname"),
            cb.sum(ord.<Integer> get("deptamt"))).groupBy(
            orgRoot.get("orgname"));

    Query qry = em.createQuery(cq);
    List<Object[]> orgList = qry.getResultList();