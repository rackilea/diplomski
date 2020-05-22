Session session = getCurrentSession();
ProjectionList projectionList = Projections.projectionList();        
projectionList.add(Projections.groupProperty("totalCode"))
        .add(Projections.groupProperty("activityCode"))
        .add(Projections.sum("amount"))
        .add(Projections.rowCount());
Criteria criteria  = session.createCriteria(Payment.class);
criteria.setProjection(projectionList);
List<Object[]> payments = criteria.list();
for (Object[] payment : payments) {
    System.out.println("totalCode: " + payment[0]);
    System.out.println("activityCode: " + payment[1]);
    System.out.println("amountSum: " + payment[2]);
    System.out.println("rowCount: " + payment[3]);
}