Criteria count = session.createCriteria(UserTable.class);
        count.setProjection(Projections.rowCount());
        Long total = count.uniqueResult();

        int n;

        Criteria criteria = session.createCriteria(UserTable.class);
        criteria.setFirstResult(total-n);
        criteria.setMaxResults(n);

        List<UserTable> list = criteria.list();