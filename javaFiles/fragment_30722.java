String query = "select hour(la.dateLastUpdated) as hour, count (la) from LoginActivity la " +
        "where la.dateLastUpdated > :date " +
        "group by hour(la.dateLastUpdated) " +
        "order by hour(la.dateLastUpdated)";

    List<Object[]> objects = getSession().createQuery(query).setParameter("date", date).list();

    for (Object[] o : objects) {
        Object hour = o[0];
        Object count = o[1];
        System.out.println(hour + ".00.00 - " + hour + ".59.59\t" + count);
    }