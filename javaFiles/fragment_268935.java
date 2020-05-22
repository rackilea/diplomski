Session session = HibernateUtil.getSessionFactory().openSession();

    session.beginTransaction();
    Stock stock = new Stock();

    stock.setStockCode("4715");
    stock.setStockName("GENM");

    session.save(stock);
    session.getTransaction().commit();