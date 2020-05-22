// Third unit of work
    Session thirdSession = HibernateUtil.getSessionFactory().openSession();
    Transaction thirdTransaction = thirdSession.beginTransaction();

    ...

    thirdTransaction.commit();   // <---- added
    thirdSession.close();        // <---- added

    //Shutting down the application
    HibernateUtil.shutdown();