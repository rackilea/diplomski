public static List<YourCustomEntity> getAggregateOrders(){
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = null;
    List<YourCustomEntity> list =  new ArrayList<YourCustomEntity>();
    try {
        tx = session.beginTransaction();
        Criteria cr = session.createCriteria(PurchaseOrders.class);
        cr.setProjection(Projections.projectionList()
                .add(Projections.sum("orderAmount").as("sumOrderAmount"))
                .add(Projections.groupProperty("orderNumber").as("agOrderNumber"))
                .add(Projections.groupProperty("orderDate").as("agOrderDate")));
        cr.setResultTransformer(Transformers.aliasToBean(YourCustomEntity.class));
        list = (List<YourCustomEntity>) cr.list();
   }catch (Exception asd) {
        System.out.println(asd.getMessage());
        if (tx != null) {
            tx.rollback();
        }
    } finally {
        session.close();
    }
     return list;
}