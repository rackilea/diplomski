CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery <Logging> query = cb.createQuery(Logging.class);

    ParameterExpression<String> p = cb.parameter(String.class,"param0" );
    Root<Logging> from = query.from(Logging.class);

    query.select(from);
        query.where( cb.equal(from.get("log_action"), "delete".getBytes()));

    System.out.println(em.createQuery(query).getResultList());