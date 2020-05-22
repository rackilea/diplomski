Calendar cal_1 = Calendar.getInstance();
    cal_1.add(Calendar.YEAR, -18);
    Date a = cal_1.getTime();
    Calendar cal_2 = Calendar.getInstance();
    cal_2.add(Calendar.YEAR, -25);
    Date b = cal_2.getTime();

    query.setParameter("a", a);
    query.setParameter("b", b);

    SELECT users FROM Users users WHERE users.eventsDate BETWEEN :a AND :b