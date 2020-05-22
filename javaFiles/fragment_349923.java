TypedQuery<Precisetimes> q = entityManager.createQuery(
        "select p from Precisetimes p where p.precisetime < :param", 
        Precisetimes.class);
Timestamp ts;
ts = Timestamp.valueOf("2017-05-31 12:12:12.123456");
q.setParameter("param", ts, TemporalType.TIMESTAMP);
System.out.println("result: " + q.getResultList());
ts = Timestamp.valueOf("2017-05-31 12:12:12.123457");
q.setParameter("param", ts, TemporalType.TIMESTAMP);
System.out.println("result: " + q.getResultList());
ts = Timestamp.valueOf("2017-05-31 12:12:12.123458");
q.setParameter("param", ts, TemporalType.TIMESTAMP);
System.out.println("result: " + q.getResultList());