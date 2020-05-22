Query query = session.getNamedQuery("sql.namedquery.captureinfo");
query.setResultTransformer(PassThroughResultTransformer.INSTANCE);
Long t0 = System.currentTimeMillis();
List<Object[]> sqlList = query.list();
Long t1 = System.currentTimeMillis();
System.err.println("SQL query took" + (t1 - t0));