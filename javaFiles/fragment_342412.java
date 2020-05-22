private List<Product> loadData(int fromIndex, int toIndex) {
    Session session =  
    HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = null;
    tx = session.beginTransaction();
    Query query = session.createQuery("from Product P WHERE P.id >= " + fromIndex + " AND P.id < " + toIndex);

    List<Product> list = query.list();
    try {
        for(Product productlist:list){
         System.out.println(productlist.getProductId()+" 
        "+productlist.getProductCode()+" "+productlist.getProductName());

         }
        Thread.sleep(201);
    }catch( Exception e) {
        e.printStackTrace();
    }
    System.out.println("Size: "+ list.size());
    return list;
    }