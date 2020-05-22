Criteria c=sess.createCriteria(Order.class)
        .createCriteria("type")
        .setProjection(
                Projections.projectionList()
                .add(Projections.groupProperty("id"))
                .add(Projections.rowCount(),"rowcount")
        )
        .addOrder(org.hibernate.criterion.Order.desc("rowcount"));

    for (Object[] result:(List<Object[]>) c.list()){
        System.out.println("type id: " + result[0] + "\tcount: " + result[1]);
    }