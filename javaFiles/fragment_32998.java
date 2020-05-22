Session session = factory.openSession();
Transaction tx = null;
try {
    tx = session.beginTransaction();
    Criteria cr = session.createCriteria(ProductServices.class);
    cr.add(Restrictions.eq("productId", strProductId));
    return (List<ProductServices>) cr.list();
      tx.commit();
     }
   catch (Exception e) {
      if (tx!=null) tx.rollback();
       e.printStackTrace(); 
  }finally {
  session.close();
 }